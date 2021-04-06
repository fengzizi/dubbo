package com.fengzi.dubbo.common.commons;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 接口返回JSON格式
 *
 * @param <T>
 */
public class JsonResp<T> implements Serializable {
    /**
     * 代码消息
     */
    private JsonCodeEnum codeEnum;
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private T data;
    /**
     * 消息
     */
    private String message;

    private boolean success = false;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public JsonResp(JsonCodeEnum code, String message) {
        super();
        setCodeEnum(code);
        this.message = message;
    }

    public JsonResp() {
        super();
    }

    public JsonResp(JsonCodeEnum code) {
        super();
        setCodeEnum(code);
    }

    public JsonResp(JsonCodeEnum code, T data, boolean success, String message) {
        super();
        setCodeEnum(code);
        this.data = data;
        this.success = success;
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (StringUtils.isBlank(message)) {
            message = getCodeEnum().getMessage();
        }
        this.message = message;
    }

    public JsonCodeEnum getCodeEnum() {
        return codeEnum;
    }

    public void setCodeEnum(JsonCodeEnum code) {
        this.codeEnum = code;
        setMessage(code.getMessage());
        if (JsonCodeEnum.isSuccess(code)) {
            setSuccess(true);
        } else {
            setSuccess(false);
        }
    }

    public JsonResp(JsonCodeEnum code, T data, String message) {
        this.codeEnum = code;
        this.data = data;
        this.message = message;
    }

    public JsonResp<T> code(JsonCodeEnum code, String msg, T data) {
        return new JsonResp<T>(code, data, msg);
    }

    public JsonResp<?> code(JsonCodeEnum code, String msg) {
        return code(code, msg, null);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 当前对象转JSON数据
     * 参数callback不为空的情况下返回JSONp数据
     *
     * @return JSON/JSONp
     */
    public String toJson() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJson();
    }

    /**
     * 返回失败
     *
     * @param message 消息
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(String message, Integer code) {
        JsonResp<E> json = getInstanceNew();
        json.setCodeEnum(JsonCodeEnum.FAIL);
        json.setCode(code == null ? JsonCodeEnum.FAIL.getCode() : code);
        json.setMessage(message);
        return json;
    }

    /**
     * 返回失败
     *
     * @param jsonCodeEnum 消息
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(JsonCodeEnum jsonCodeEnum) {
        JsonResp<E> json = getInstanceNew();
        json.setCodeEnum(jsonCodeEnum);
        json.setCode(jsonCodeEnum.getCode());
        json.setMessage(jsonCodeEnum.getMessage());
        return json;
    }

    /**
     * 返回失败
     *
     * @param jsonCodeEnum 消息
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(JsonCodeEnum jsonCodeEnum, E data) {
        JsonResp<E> json = getInstanceNew();
        json.setCodeEnum(jsonCodeEnum);
        json.setCode(jsonCodeEnum.getCode());
        json.setMessage(jsonCodeEnum.getMessage());
        json.setData(data);
        return json;
    }

    /**
     * 返回失败
     *
     * @param message 消息
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(String message, E data) {
        return toFail(message, JsonCodeEnum.FAIL.getCode(), data);
    }

    /**
     * 返回失败
     *
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(String message, Integer code, E data) {
        JsonResp json = getInstanceNew();
        json.setCodeEnum(JsonCodeEnum.FAIL);
        json.setCode(code == null ? JsonCodeEnum.FAIL.getCode() : code);
        json.setMessage(message);
        json.setData(data);
        return json;
    }

    /**
     * 返回失败
     *
     * @return toJson
     */
    public static JsonResp toFail(Integer code) {
        return toFail("", code);
    }

    /**
     * 返回失败
     *
     * @return toJson
     */
    public static <E> JsonResp<E> toFail(String message) {
        return toFail(message, null);
    }

    /**
     * 返回失败
     *
     * @return toJson
     */
    public static JsonResp toFail() {
        return toFail("", null);
    }

    /**
     * 空数据
     *
     * @return toJson
     */
    public static JsonResp isEmpty() {
        JsonResp json = getInstanceNew();
        json.setCodeEnum(JsonCodeEnum.EMPTY);
        json.setMessage("空数据");
        return json;
    }

    /**
     * 登陆超时
     *
     * @return toJson
     */
    public static JsonResp overtime() {
        JsonResp json = getInstanceNew();
        json.setCodeEnum(JsonCodeEnum.OVERTIME);
        json.setCode(0);
        json.setMessage("未登陆/登陆超时");
        return json;
    }

    /**
     * 自定义返回code
     *
     * @param code    JsonCodeEnum
     * @param message 消息
     * @return toJson
     */
    private String toJson(JsonCodeEnum code, String message) {
        setCodeEnum(code);
        setMessage(message);
        return toJson();
    }

    /**
     * 自定义返回code
     *
     * @param code JsonCodeEnum
     *             消息
     * @return toJson
     */
    public String toJson(JsonCodeEnum code) {
        return toJson(code, null);
    }

    /**
     * 失败消息（消息自定义）
     *
     * @param message 消息
     * @return toJson
     */
    public String fail(String message) {
        return toJson(JsonCodeEnum.FAIL, message);
    }

    /**
     * 失败消息
     *
     * @return 失败
     */
    public String fail() {
        setCodeEnum(JsonCodeEnum.FAIL);
        return toJson();
    }

    /**
     * 服务器出错了
     */
    public JsonResp error() {
        fail("服务器出错了");
        return this;
    }

    /**
     * 参数错误
     *
     * @param message 消息
     * @return toJson
     */
    public JsonResp parm(String message) {
        setCodeEnum(JsonCodeEnum.PARAMETER_INVALID);
        setMessage(message);
        return this;
    }

    /**
     * 失败消息
     *
     * @return 失败
     */
    JsonResp parm() {
        return parm(null);
    }

    /**
     * 成功消息
     *
     * @param message 消息
     * @return toJson
     */
    public String success(String message) {
        return toJson(JsonCodeEnum.SUCCESS, message);
    }

    /**
     * 成功消息
     *
     * @return toJson
     */
    public String success() {
        return toJson(JsonCodeEnum.SUCCESS, null);
    }

    /**
     * 返回成功
     *
     * @param data    数据
     * @param message 消息
     * @return toJson
     */
    private static <N> String toSu(N data, String message) {
        JsonResp<N> json = getInstanceNew();
        json.setCodeEnum(JsonCodeEnum.SUCCESS);
        json.setMessage(message);
        json.setData(data);
        return json.toJson();
    }

    /**
     * 自定义
     *
     * @param jsonCodeEnum code
     * @param message      消息
     * @return JSON
     */
    private static JsonResp toEnum(JsonCodeEnum jsonCodeEnum, String message) {
        JsonResp json = new JsonResp();
        json.setCodeEnum(jsonCodeEnum);
        json.setMessage(message);
        return json;
    }

    /**
     * 自定义
     *
     * @param jsonCodeEnum code
     * @return JSON
     */
    public static JsonResp toEnum(JsonCodeEnum jsonCodeEnum) {
        return toEnum(jsonCodeEnum, null);
    }

    /**
     * 返回成功
     *
     * @return toJson
     */
    public static String toSu(String message) {
        return toSu(null, message);
    }

    /**
     * 返回成功
     *
     * @return toJson
     */
    public static String toSu() {
        return toSu(null, null);
    }

    /**
     * 获取新实例
     *
     * @return 实例
     */
    private static <N> JsonResp<N> getInstanceNew() {
        return new JsonResp<>();
    }

    /**
     * 判断是否加载成功
     *
     * @return 成功/失败
     */
    public boolean loadSuccess() {
        if (codeEnum == JsonCodeEnum.SUCCESS) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置成功值
     *
     * @param message 消息
     */
    public void setSucc(String message, T data) {
        setData(data);
        setCodeEnum(JsonCodeEnum.SUCCESS);
        setMessage(message);
    }

    /**
     * 设置成功值
     *
     * @param message 消息
     */
    public void setSucc(String message) {
        setSucc(message, null);
    }

    /**
     * 设置成功值
     *
     * @param message 消息
     */
    public JsonResp<T> succ(String message, Integer code) {
        return succ(message, null, code);
    }

    /**
     * 设置成功值
     *
     * @param message 消息
     */
    private JsonResp<T> succ(String message, T data, Integer code) {
        setCodeEnum(JsonCodeEnum.SUCCESS);
        setMessage(message);
        setCode(code == null ? JsonCodeEnum.SUCCESS.getCode() : code);
        setData(data);
        return this;
    }

    /**
     * 设置成功值
     */
    public JsonResp<T> succ(T data, Integer code) {
        return succ(null, data, code);
    }

    /**
     * 设置成功值
     */
    public void setSucc() {
        setSucc(null);
    }

    /**
     * 设置参数不合法值
     *
     * @param message 消息
     */
    public void setParm(String message) {
        setCodeEnum(JsonCodeEnum.PARAMETER_INVALID);
        setMessage(message);
    }

    /**
     * 设置参数不合法值
     */
    public void setParm() {
        setSucc(null);
    }

    /**
     * 数据为空
     *
     * @param message 消息
     * @return 自己
     */
    public JsonResp<T> empty(String message) {
        setCodeEnum(JsonCodeEnum.EMPTY);
        setMessage(message);
        return this;
    }

    /**
     * 数据为空
     *
     * @return 自己
     */
    public JsonResp empty() {
        return empty(null);
    }

    /**
     * 返回成功
     *
     * @param message 消息
     * @param data    数据
     * @return 新对象
     */
    public static <E> JsonResp<E> ok(String message, E data) {
        return new JsonResp<E>().succ(message, data, null);
    }

    /**
     * 返回成功
     *
     * @param data 数据
     * @return 新对象
     */
    public
    static <E> JsonResp<E> ok(E data) {
        return ok(null, data);
    }

    /**
     * 返回成功
     *
     * @param message 消息
     * @return 新对象
     */
    public static JsonResp<?> ok(String message) {
        return ok(message, null);
    }


    /**
     * 返回成功
     *
     * @return 新对象
     */
    public static <E> JsonResp<E> ok() {
        return ok(null, null);
    }

    /**
     * 返回成功
     *
     * @param message 消息
     * @param data    数据
     * @return 新对象
     */
    public static <E> JsonResp<E> ok(String message, E data, Integer code) {
        return new JsonResp<E>().succ(message, data, code);
    }

    /**
     * 返回成功
     *
     * @param data 数据
     * @return 新对象
     */
    public
    static <E> JsonResp<E> ok(E data, Integer code) {
        return ok(null, data, code);
    }

    /**
     * 返回成功
     *
     * @param message 消息
     * @return 新对象
     */
    public static <E> JsonResp<E> ok(String message, Integer code) {
        return ok(message, null, code);
    }


    /**
     * 返回成功
     *
     * @return 新对象
     */
    public static JsonResp ok(Integer code) {
        return ok(null, code);
    }

    /**
     * 返回失败
     *
     * @param message 消息
     * @return 新对象
     */
    public static JsonResp fa(String message) {
        JsonResp json = new JsonResp();
        json.setCodeEnum(JsonCodeEnum.FAIL);
        json.setMessage(message);
        return json;
    }

    /**
     * 判断是否成功
     *
     * @return 自己
     */
    public JsonResp passSuccess() {
        if (loadSuccess()) {
            this.setSuccess(true);
        } else {
            this.setSuccess(false);
        }
        return this;
    }

    /**
     * 返回 数据空
     *
     * @param message 消息
     * @return 新对象
     */
    private static JsonResp toEmpty(String message) {
        JsonResp json = new JsonResp();
        json.setCodeEnum(JsonCodeEnum.EMPTY);
        json.setMessage(message);
        return json;
    }

    /**
     * 返回 数据空
     *
     * @return 新对象
     */
    static JsonResp toEmpty() {
        return toEmpty(null);
    }

    /**
     * list 是否空数据检测
     *
     * @param list    列表
     * @param message 消息
     * @return JSON
     */
    public static <N, L extends Collection<N>> JsonResp<L> list(L list, String message) {
        return new JsonResp<L>().collection(list, message);
    }

    /**
     * list 是否空数据检测
     *
     * @param list 列表
     * @return JSON
     */
    public static <N, L extends Collection<N>> JsonResp<L> list(L list) {
        return list(list, null);
    }

    public <N, L extends Collection<N>> JsonResp<L> collection(L list) {
        return collection(list, null);
    }

    public <N, L extends Collection<N>> JsonResp<L> collection(L list, String message) {
        JsonResp<L> collectionJson = new JsonResp<>();
        if (CollectionUtils.isEmpty(list)) {
            collectionJson.empty(message);
        } else {
            collectionJson.succ(list, null);
        }
        return collectionJson;
    }

    /**
     * 返回数据JSON
     *
     * @param ns       数据
     * @param emptyMsg 数组为空消息
     * @param <N>      数据类型
     */
    public static <N> JsonResp<N[]> array(N[] ns, String emptyMsg) {
        JsonResp<N[]> collectionJson = new JsonResp<>();
        if (ArrayUtils.isEmpty(ns)) {
            collectionJson.empty(emptyMsg);
        }
        return collectionJson.succ(ns, null);
    }

    /**
     * {@Link}array(N[]) 默认消息
     */
    public static <N> JsonResp<N[]> array(N[] ns) {
        return array(ns, null);
    }

    public JsonResp failRes(String message) {
        return setJsonCode(JsonCodeEnum.FAIL, message);
    }

    JsonResp failRes() {
        return failRes(null);
    }

    private JsonResp setJsonCode(JsonCodeEnum jsonCodeEnum, String message) {
        setCodeEnum(jsonCodeEnum);
        setMessage(message);
        return this;
    }

    /**
     * @param data    数据
     * @param message 数据为空消息
     * @return JSON
     */
    public JsonResp<T> data(T data, String message) {
        return data(data, message, null);
    }

    /**
     * @param data      数据
     * @param message   数据为空消息
     * @param okMessage OK消息
     * @return JSON
     */
    public JsonResp<T> data(T data, String message, String okMessage) {
        JsonResp<T> json = new JsonResp<>();
        if (data == null) {
            json.empty(message);
        } else {
            json.succ(okMessage, data, null);
        }
        return json;
    }


    public JsonResp<T> data() {
        return data(getData());
    }

    /**
     * @param data 数据
     * @return JSON
     */
    public JsonResp<T> data(T data) {
        return data(data, null);
    }

    /**
     * 登陆已失效或未登陆
     *
     * @param message 消息
     * @return this
     */
    public JsonResp login(String message) {
        return new JsonResp(JsonCodeEnum.OVERTIME, message);
    }

    /**
     * 登陆已失效或未登陆
     *
     * @return this
     */
    public JsonResp login() {
        return login("登陆已失效或未登陆");
    }

    /**
     * 分页，返回数据
     *
     * @return this
     */
//    public static <F> JsonResp<PageDto<F>> dataPage(IPage<F> page) {
//        return JsonResp.ok(new PageDto<>(page.getCurrent(), page.getSize(), page.getRecords(), page.getTotal()));
//    }


    /**
     * 返回列表数据
     *
     * @return this
     */
    public static JsonResp dataList(List list) {
        if (list == null || list.size() == 0) {
            return JsonResp.ok();
        }
        return JsonResp.ok(new PageDto(1, list.size(), list, list.size()));
    }

}