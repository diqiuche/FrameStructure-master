package com.android.tanlifei.framestructure.engine.interf;

import android.view.View;

import com.android.tanlifei.framestructure.common.view.prompt.BasePromptDialog;

/**
 * 提示dialog回调
 *
 * <ul>
 * <strong>基本方法及自己方法</strong>
 * <li>{@link #liftBtnOnClickListener(BasePromptDialog,View,int)} 左边按钮点击监听</li>
 * <li>{@link #rightBtnOnClickListener(BasePromptDialog,View,int)}右边按钮点击监听</li>
 * </ul>
 * @author tanlifei
 * @date 2015年2月3日 上午10:50:58
 */
public interface IPromptDialogBtnDefaultCallBack {

    /**
     * 左边按钮点击监听
     * @param promptDialog 当前提示框
     * @param v 当前点击view
     * @param callBackTag 多个弹出框时区分标识
     */
    void liftBtnOnClickListener(BasePromptDialog promptDialog, View v,int callBackTag);

    /**
     * 右边按钮点击监听
     * @param promptDialog 当前提示框
     * @param v 当前点击view
     * @param callBackTag 多个弹出框时区分标识
     */
    void rightBtnOnClickListener(BasePromptDialog promptDialog, View v,int callBackTag);
}
