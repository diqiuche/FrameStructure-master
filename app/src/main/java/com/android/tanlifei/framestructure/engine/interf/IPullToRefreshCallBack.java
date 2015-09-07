package com.android.tanlifei.framestructure.engine.interf;

import com.android.tanlifei.framestructure.adpater.base.ListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import java.util.List;
import java.util.Map;

/**
 * PullToRefresh 刷新基本方法设置回调
 * <ul>
 * <strong>基本方法及自己方法</strong>
 * <li>{@link #taskUrl()} 列表请求接口的路径</li>
 * <li>{@link #taskParams(Map)}  列表请求接口参数</li>
 * <li>{@link #parseClassName()} 获取列表刷新返回json自动解析成对象的实体名</li>
 * <li>{@link #customParseJson(String, PullToRefreshBase.Mode)} 手动解析json</li>
 * <li>{@link #getAdapter()} 获取列表的适配器</li>
 * <li>{@link #getList()} 获取列表存储容器集合</li>
 * </ul>
 *
 * @author tanlifei
 * @date 2015年2月14日 上午11:30:51
 *
 */
public interface IPullToRefreshCallBack {

    /**
     * 请求的Url
     */
    String taskUrl();

    /**
     * map里已经放了基本，设置请求的参数
     *
     * @param map
     * @return Map<String,Object> 返回类型
     */
    Map<String, Object> taskParams(Map<String, Object> map);

    /**
     * json解析的类对象,通过fastjson 解析json时反射出相应的实体bean，所以要传入一个实体类对象
     *
     * @return Class<?> 要解析的实体
     */
    Class<?> parseClassName();


    /**
     * 手动解析json
     *
     * @param json 请求的json
     * @param mode 类型，上拉还是下拉
     */
    void customParseJson(String json, PullToRefreshBase.Mode mode);


    /**
     * 设置Adapter
     *
     * @return ListAdapter 返回类型
     */
    ListAdapter getAdapter();


    /**
     * 设置ListView
     */
    List<?> getList();


}