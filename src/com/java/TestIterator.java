package com.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestIterator {

    static Map<String, String> redisKeys;

    public static void main(String args[]){

        redisKeys = new HashMap<>();
        redisKeys.put("KeyX", "KeyX");
        redisKeys.put("KeyW", "KeyW");
        redisKeys.put("KeyY", "KeyY");
        redisKeys.put("KeyZ", "KeyZ");
        redisKeys.put("KeyS", "KeyS");

        Set<String> rKeys = new HashSet<>();
        rKeys.add("KeyA");
        rKeys.add("KeyB");
        rKeys.add("KeyC");
        rKeys.add("KeyD");
        rKeys.add("KeyZ");
        loadWhitelistAttrKeysHelper(rKeys);
    }

    private static void loadWhitelistAttrKeysHelper(Set<String> rKeys) {
        System.out.println("loadWhitelistAttrKeysHelper - start");
        rKeys.forEach(k -> redisKeys.putIfAbsent(k, k));
        removeOutdatedWhitelistKeys(rKeys);
        System.out.println("loadWhitelistAttrKeysHelper - end");
    }

    private static void removeOutdatedWhitelistKeys(Set<String> rKeys) {
        System.out.println("loadWhitelistAttrKeysHelper - rKeys "+rKeys);
        System.out.println("loadWhitelistAttrKeysHelper - BEFORE redisKeys "+redisKeys);
        Iterator<String> cacheIterator = redisKeys.keySet().iterator();
        while(cacheIterator.hasNext()){
            if(!rKeys.contains(cacheIterator.next())){
                cacheIterator.remove();
            }
        }
        System.out.println("loadWhitelistAttrKeysHelper - AFTER redisKeys "+redisKeys);
    }
}
