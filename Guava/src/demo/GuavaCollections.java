package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.plaf.synth.SynthScrollBarUI;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;

public class GuavaCollections {

    public static void main(String[] args) {
//        testMultiSet();
//        testMultiMap();
//        testBiMap();
        testTable();
    }

    private static void testMultiSet() {
        // original Set allows no duplicates
        Set<String> set = new HashSet<>();
        System.out.println("a: " + set.add("a"));
        System.out.println("b: " + set.add("b"));
        System.out.println(set.toString());
        System.out.println("a: " + set.add("a"));
        System.out.println(set.toString());

        System.out.println("====== multiset ======");

        Multiset<String> multiset = HashMultiset.create();
        System.out.println("a: " + multiset.add("a"));
        System.out.println("b: " + multiset.add("b"));
        System.out.println(multiset.toString());
        System.out.println("a: " + multiset.add("a"));
        System.out.println(multiset.toString());
        System.out.println("#a: " + multiset.count("a"));
        System.out.println("#b: " + multiset.count("b"));
        System.out.println("#c: " + multiset.count("c"));
        System.out.println("Size: " + multiset.size());
        System.out.println("set c count to 2: There was " + multiset.setCount("c", 2) + " and the new set is " + multiset.toString());
        System.out.println("Element set: " + multiset.elementSet());
        multiset.entrySet().forEach(entry -> System.out.println("Entry: " + entry.toString() + ": " + entry.getCount() + " occurences of " + entry.getElement()));
        System.out.println("Remove 1 c: " + multiset.remove("c", 1));
        System.out.println(multiset.toString());
        System.out.println("Remove 2 c: " + multiset.remove("c", 2));
        System.out.println(multiset.toString());
    }

    private static void testMultiMap() {
        Multimap<String, String> teams = ArrayListMultimap.create();

        teams.put("22", "Dani");
        teams.put("22", "Claudine");
        teams.put("22", "Luidson");
        teams.put("22", "Eric");
        teams.put("22", "Ramon");
        teams.put("22", "Petrini");
        teams.put("8", "Giovanna");
        teams.put("8", "Rayla");
        teams.put("8", "Henrique");
        teams.put("8", "Aldo");
        teams.put("8", "Lucas");

        System.out.println("as multimap: " + teams);
        System.out.println("as map:" + teams.asMap());
        System.out.println("Contains Dani in 22? " + teams.containsEntry("22", "Dani"));
        System.out.println("Contains Dani in 8? " + teams.containsEntry("8", "Dani"));
        System.out.println("Contains team 7? " + teams.containsKey("27"));
        System.out.println("Contains Rayla? " + teams.containsValue("Rayla"));
        System.out.println("Entries: " + teams.entries());
        System.out.println("Keys as multiset: " + teams.keys());
        System.out.println("Keys as set: " + teams.keySet());
        teams.replaceValues("8", Arrays.asList("Rayla", "Giovanna"));
        System.out.println("New team 8: " + teams.toString());
        for (Map.Entry<String,  Collection<String>> entry : teams.asMap().entrySet()) {
            String key = entry.getKey();
            Collection<String> value =  teams.get(key);
            System.out.println(key + ":" + value);
         }
        System.out.println("Values: " + teams.values());
        }
     

    public static void testBiMap(){
        Map<String, String> map = new HashMap<>();
        map.put("cat1", "wf1");
        map.put("cat1", "wf2");
        map.put("cat2", "wf1");
        map.put("cat2", "wf3");
        map.put("cat3", "wf4");
        System.out.println("Map: " + map.toString());

   BiMap<String, String> bimap = HashBiMap.create();

        bimap.put("wf1", "bpmn1");
        bimap.put("wf2", "bpmn2");
        System.out.println("bimap: " + bimap);
    
        //IllegalArgumentException:
//    System.out.println("Using repeated value: " + bimap.put("wf3", "bpmn1") + "; " + bimap); 
//        System.out.println("putIfAbsent repeated value: " + bimap.putIfAbsent("wf6", "bpmn1") + "; " + bimap);

        System.out.println("putIfAbsent repeated key: " + bimap.putIfAbsent("wf0", "bpmn6") + "; " + bimap);
    System.out.println("Compute: " + bimap.compute("wf3", (k,v) -> (v==null)? v="null" : v) + bimap);
    System.out.println("Contains wf2? " + bimap.containsKey("wf2"));
    System.out.println("Force put of bpmn1 into wf7: " + bimap.forcePut("wf7", "bpmn1") + "; " + bimap);
    System.out.println("get wf8 or default: " + bimap.getOrDefault("wf8", "no value"));
    System.out.println("Merge: " + bimap.merge("wf2", "bpmn3", String::concat) + bimap);
    System.out.println("Values: " + bimap.values());
    System.out.println("Inverse: " + bimap.inverse());
    
    bimap.putAll(map);
    System.out.println("PutAll repeated value: " + bimap); //faz force put
    }

    public static void testTable(){
        Table<String, String, String> workflows = HashBasedTable.create();

        /**
         * |     | wf1    | wf2    |
         * | c1  | bpmn11 | bpmn12 |
         * | c2  | bpmn21 | bpmn22 |
         */
        
        workflows.put("c1", "wf1", "bpmn11");
        workflows.put("c1", "wf2", "bpmn12");
        workflows.put("c2", "wf1", "bpmn21");
        workflows.put("c2", "wf2", "bpmn22");
        
        System.out.println("Table: " + workflows);
        System.out.println("Contains c1, wf1? " + workflows.contains("c1", "wf1"));
        System.out.println("Contains c2, wf3? " + workflows.contains("c1", "wf3"));
        System.out.println("Contains column wf1? " + workflows.containsColumn("wf1"));
        System.out.println("Contains row c2? " + workflows.containsRow("c2"));
        System.out.println("Contains value bpmn22? " + workflows.containsValue("bpmn22"));
        System.out.println("[c1, wf1] = " + workflows.get("c1", "wf1"));
        System.out.println("Size: " + workflows.size());
        System.out.println("CellSet: " + workflows.cellSet());
        System.out.println("Column wf1: " + workflows.column("wf1"));
        System.out.println("Row c2: " + workflows.row("c2"));
        System.out.println("Column key set: " + workflows.columnKeySet());
        System.out.println("Row key set: " + workflows.rowKeySet());
        System.out.println("Column map: " + workflows.columnMap());
        System.out.println("Row map: " + workflows.rowMap());
        System.out.println("Values: " + workflows.values());
    }
}
