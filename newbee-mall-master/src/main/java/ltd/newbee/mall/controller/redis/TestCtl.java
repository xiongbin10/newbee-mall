package ltd.newbee.mall.controller.redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import ltd.newbee.mall.util.ToolRedis;

@RestController
@RequestMapping("test")
public class TestCtl {
    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Autowired
    private ToolRedis toolRedis;

    /**
     * <h6>功能:新增</h6>
     * 
     * @param key
     * @param value
     * @return 
     */
    @RequestMapping("set")
    public String redisSet(String key, String value){
        return String.valueOf(toolRedis.set(key,value, 300));
    }

    /**
     * <h6>功能:获取</h6>
     * 
     * @param key
     * @return 
     */
    @RequestMapping("get")
    public String redisGet(String key){
        return JSONObject.toJSONString(toolRedis.get(key));
    }

    /**
     * <h6>功能:设置有效期</h6>
     * 
     * @param key
     * @return 
     */
    @RequestMapping("expire")
    public String expire(String key){
        return String.valueOf(toolRedis.expire(key,ExpireTime));
    }

    /**
     * <h6>功能:获取有效期</h6>
     *  时间(秒) -1:永久有效 -2:键不存在
     * @param key
     * @return 
     */
    @RequestMapping("getExpire")
    public String getExpire(String key){
        return String.valueOf(toolRedis.getExpire(key));
    }
}