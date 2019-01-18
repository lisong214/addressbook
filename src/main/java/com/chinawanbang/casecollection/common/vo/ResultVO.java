package com.chinawanbang.casecollection.common.vo;

import java.util.HashMap;
import java.util.Map;

import com.chinawanbang.casecollection.common.constant.KeyEnum;
import com.chinawanbang.casecollection.common.constant.MsgEnum;

/**
 * 后台返回前台结果 VO
 * @author LS
 * @date 2018-07-04 19:37
 */
public class ResultVO {
    private boolean success;
    private Map<String, Object> data = new HashMap<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Object getAttrValue(KeyEnum attrKey) {
        return this.data.get(attrKey.getName());
    }

    public void setAttrValue(KeyEnum attrKey, Object attrValue) {
        this.data.put(attrKey.getName(), attrValue);
    }

    public void setMessage(MsgEnum msgEnum) {
        if (msgEnum == null) return;
        if (isSuccess()) {
            this.setAttrValue(KeyEnum.CODE, msgEnum.getCode());
            this.setAttrValue(KeyEnum.MESSAGE, msgEnum.getMessage());
        } else {
            this.setAttrValue(KeyEnum.ERR_CODE, msgEnum.getCode());
            this.setAttrValue(KeyEnum.ERR_MSG, msgEnum.getMessage());
        }
    }
}
