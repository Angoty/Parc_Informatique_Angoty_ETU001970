package information;

public class Information{

    public String getUser(){
        return System.getProperty("user.name"); //DELL
    }
    public String getName(){
        return System.getProperty("os.name"); //Windows 10
    }
    public String getVersion(){
        return System.getProperty("os.version"); //10.0 
    }
    public String getArchitecture(){
        return System.getProperty("os.arch"); //Amd64
    }

    public long getMaxMemory(){
        Runtime runtime=Runtime.getRuntime(); 
        return runtime.maxMemory()/1024/1024;
    }
    public long getFreeMemory(){
        Runtime runtime=Runtime.getRuntime(); 
        return runtime.freeMemory()/1024/1024;
    }
    public long getUsingMemory(){
        return (getMaxMemory()-getFreeMemory());
    }

    public String getAllInformations(){
        String information="";
        information=information.concat(getUser()+";");
        information=information.concat(getName()+";");
        information=information.concat(getVersion()+";");
        information=information.concat(getArchitecture()+";");
        information=information.concat(getMaxMemory()+";");
        information=information.concat(getFreeMemory()+";");
        information=information.concat(getUsingMemory()+";");

        return information;
    }
}