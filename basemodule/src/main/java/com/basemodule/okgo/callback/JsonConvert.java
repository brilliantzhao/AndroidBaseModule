package com.basemodule.okgo.callback;

import com.basemodule.base.IBaseApplication;
import com.basemodule.baseapp.BaseRespose;
import com.basemodule.okgo.utils.Convert;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.convert.Converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）Github地址：https://github.com/jeasonlzy
 * 版    本：1.0
 * 创建日期：16/9/11
 * 描    述：
 * -
 * -
 * -
 * -该类主要用于 OkRx 调用，直接解析泛型，返回数据对象，若不用okrx，可以删掉该类
 * -
 * -
 * -
 * 修订历史：
 * ================================================
 */
public class JsonConvert<T extends BaseRespose> implements Converter<T> {

    /**
     * 该方法是子线程处理，不能做ui相关的工作
     * 主要作用是解析网络返回的 response 对象,生产onSuccess回调中需要的数据对象
     * 这里的解析工作不同的业务逻辑基本都不一样,所以需要自己实现,以下给出的时模板代码,实际使用根据需要修改
     * <pre>
     * OkGo.get(Urls.URL_METHOD)//
     *     .tag(this)//
     *     .execute(new DialogCallback<LzyResponse<ServerModel>>(this) {
     *          @Override
     *          public void onSuccess(LzyResponse<ServerModel> responseData, Call call, Response response) {
     *              handleResponse(responseData.data, call, response);
     *          }
     *     });
     * </pre>
     */
    @Override
    public T convertSuccess(Response response) throws Exception {

        // 重要的事情说三遍，不同的业务，这里的代码逻辑都不一样，如果你不修改，那么基本不可用

        //以下代码是通过泛型解析实际参数,泛型必须传
        //这里为了方便理解，假如请求的代码按照上述注释文档中的请求来写，那么下面分别得到是

        //com.lzy.demo.callback.DialogCallback<com.lzy.demo.model.LzyResponse<com.lzy.demo.model.ServerModel>> 得到类的泛型，包括了泛型参数
        Type genType = getClass().getGenericSuperclass();
        //从上述的类中取出真实的泛型参数，有些类可能有多个泛型，所以是数值
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        //我们的示例代码中，只有一个泛型，所以取出第一个，得到如下结果
        //com.lzy.demo.model.LzyResponse<com.lzy.demo.model.ServerModel>
        Type type = params[0];

        //这里我们既然都已经拿到了泛型的真实类型，即对应的 class ，那么当然可以开始解析数据了，我们采用 Gson 解析
        //以下代码是根据泛型解析数据，返回对象，返回的对象自动以参数的形式传递到 onSuccess 中，可以直接使用
        JsonReader jsonReader = new JsonReader(response.body().charStream());
        //有数据类型，表示有data
        T data = Convert.fromJson(jsonReader, type);
        response.close();
        //===
        String code = data.code + "";
        //这里的0是以下意思
        //一般来说服务器会和客户端约定一个数表示成功，其余的表示失败，这里根据实际情况修改
        if (code.equals(IBaseApplication.getRespSuccessCode())) {
            //noinspection unchecked
        } else if (code.equals(IBaseApplication.getRespNotLogin())) {
            //比如：用户尚未登录，在此实现相应的逻辑，弹出对话或者跳转到其他页面等,该抛出错误，会在onError中回调。
            throw new IllegalStateException("用户尚未登录");
        } else if (code.equals(IBaseApplication.getRespLoginOtherDevice())) {
            //比如：用户账号在其他设别上登录，在此实现相应的逻辑，弹出对话或者跳转到其他页面等,该抛出错误，会在onError中回调。
            throw new IllegalStateException("用户账号在其他设别上登录");
        } else {
            throw new IllegalStateException("错误代码：" + code + "，错误信息：" + data.msg);
        }
        return data;
    }
}