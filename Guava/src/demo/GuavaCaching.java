package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCaching {

    public static void main(String[] args) {

      //create a cache for dunning scenarios based on their id
        LoadingCache<String, DunningScenario> cache =  CacheBuilder.newBuilder()
                                                                   .maximumSize(100) // maximum 100 records can be cached
                                                                   .expireAfterAccess(30, TimeUnit.MINUTES) // cache will expire after 30 minutes of access
                                                                   .build(new CacheLoader<String, DunningScenario>()
                                                                   { // build the cacheloader
                                                                       @Override
                                                                       public DunningScenario load(String id) throws Exception {
                                                                               //make the expensive call
                                                                               return getDunningScenariosFromDatabase(id);
                                                                       } 
                                                                   });

        try {           
            //on first invocation, cache will be populated with corresponding
            //ds record
            System.out.println("Invocation #1");
            System.out.println(cache.get("ds1"));
            System.out.println(cache.get("ds2"));
            System.out.println(cache.get("ds3"));
            
            //second invocation, data will be returned from cache
            System.out.println("Invocation #2");
            System.out.println(cache.get("ds1"));
            System.out.println(cache.get("ds2"));
            System.out.println(cache.get("ds3"));
  
          //3rd invocation, data will be returned from cache
            System.out.println("Invocation #3");
            System.out.println(cache.get("ds1"));
            System.out.println(cache.get("ds2"));
            System.out.println(cache.get("ds3"));

            System.out.println("Cache size: " + cache.size());
            System.out.println("Cache as map: " + cache.asMap());
            System.out.println("Get all: " + cache.getAll(Arrays.asList("ds1", "ds2", "ds3")));
            // InvalidCahceLoadException when trying to get from db
//            System.out.println("Get inexistent: " + cache.get("ds4"));
            System.out.println("Get all present: " + cache.getAllPresent(Arrays.asList("ds1", "ds4")));
            System.out.println("Get if present: ds1 = " + cache.getIfPresent("ds1") + ", ds4 = " + cache.getIfPresent("ds4"));
//InvalidCacheLoadException when trying to get ds4
            //            System.out.println("Get if unchecked: ds1 = " + cache.getUnchecked("ds1") + ", ds4 = " + cache.getUnchecked("ds4"));
            System.out.println("Stats: " + cache.stats());
            cache.invalidate("ds1");
            System.out.println("get invalidated: " + cache.get("ds1"));
         }catch (ExecutionException e) {
            e.printStackTrace();
         }
    }

    private static DunningScenario getDunningScenariosFromDatabase(String id) {
        DunningScenario ds1 = new DunningScenario("ds1", "first ds", "c1", "bpmn1");
        DunningScenario ds2 = new DunningScenario("ds2", "second ds", "c1", "bpmn2");
        DunningScenario ds3 = new DunningScenario("ds3", "third ds", "c2", "bpmn3");

        Map<String, DunningScenario> database = new HashMap<String, DunningScenario>();
        
        database.put("ds1", ds1);
        database.put("ds2", ds2);
        database.put("ds3", ds3);
        
        System.out.println("Getting from db");
        
        return database.get(id);       
     }
}
