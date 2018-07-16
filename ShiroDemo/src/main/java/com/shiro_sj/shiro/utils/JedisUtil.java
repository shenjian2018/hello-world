
/**
 * @author CPR199
 *
 */
package com.shiro_sj.shiro.utils;

import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
	protected Logger logger = LoggerFactory.getLogger(JedisUtil.class);
	@Resource
	private JedisPool jedisPool;

	private Jedis getResource() {
		return jedisPool.getResource();
	}

	public byte[] set(byte[] key, byte[] value) {
		Jedis jedis = getResource();
		try {
			jedis.set(key, value);
			return value;
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			jedis.close();
		}
		return null;

	}
	

    public void expire(byte[] key, int i) {
        Jedis jedis =  getResource();
        try {
            jedis.expire(key,i);
        } finally {
            jedis.close();
        }
    }

    public byte[] get(byte[] key) {
        Jedis jedis =  getResource();
        try {
           return jedis.get(key);
        } finally {
            jedis.close();
        }
    }

    public void del(byte[] key) {
        Jedis jedis =  getResource();
        try {
            jedis.del(key);
        } finally {
            jedis.close();
        }
    }

    public Set<byte[]> keys(String shiro_session_prefix) {
        Jedis jedis =  getResource();
        try {
            return jedis.keys((shiro_session_prefix+"*").getBytes());
        } finally {
            jedis.close();
        }
    }

}