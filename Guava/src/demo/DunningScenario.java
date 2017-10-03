package demo;

import com.google.common.base.Objects;

public class DunningScenario {

    private String myId;
    private String myName;
    private String myCategoryId;
    private String myBpmn;

    public DunningScenario(String id, String name, String categoryId, String bpmn){
        myId = id;
        myName = name;
        myCategoryId = categoryId;
        myBpmn = bpmn;
    }

    public String getId(){
        return myId;
    }

    public String getName(){
        return myName;
    }

    public String getCategoryId(){
        return myCategoryId;
    }

    public String getBpmn(){
        return myBpmn;
    }

    @Override
    public boolean equals(Object object)
    {
       if(!(object instanceof DunningScenario) || object == null){
          return false;
       }

       DunningScenario dunningScenario = (DunningScenario) object;

       // Objects.equal("test", "test") == true
       // Objects.equal("test", null) == false
       // Objects.equal(null, "test") == false
       // Objects.equal(null, null) == true

       return Objects.equal(myId, dunningScenario.getId())
          && Objects.equal(myName, dunningScenario.getName())
          && Objects.equal(myCategoryId, dunningScenario.getCategoryId())
          && Objects.equal(myBpmn, dunningScenario.getBpmn());
    }

    @Override
    public int hashCode() {
       //no need to compute hashCode by self
       return Objects.hashCode(myId, myCategoryId);
    }

    @Override
    public String toString(){
        return String.format("ID: %s, name: %s, category: %s, bpmn: %s", myId, myName, myCategoryId, myBpmn);
    }
}
