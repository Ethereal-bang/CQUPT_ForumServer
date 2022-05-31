package com.bei.forum.common;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
public class Res {

    private boolean flag;

    private String msg;

    private Map<String, Object> data = new HashMap<>();

    private Res() {}

    public static Res ok() {
        Res res  = new Res();
        res.setFlag(true);
        res.setMsg("查询成功");
        return res;
    }

    public static Res err() {
        Res res  = new Res();
        res.setFlag(false);
        res.setMsg("查询失败");
        return res;
    }

    public Res data(String key, Object val) {
        this.data.put(key, val);
        return this;
    }

    public Res setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}