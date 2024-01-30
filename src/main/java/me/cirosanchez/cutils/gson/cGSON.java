package me.cirosanchez.cutils.gson;


import com.google.gson.Gson;
import com.google.gson .GsonBuilder;
import me.cirosanchez.cutils.gson.serializers.JsonConfigurationSerialization;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class cGSON {
    private Gson gson = new GsonBuilder().registerTypeHierarchyAdapter(ConfigurationSerializable.class, JsonConfigurationSerialization.TYPE_HIERARCHY_ADAPTER).setPrettyPrinting().create();

    public String toJson(Object object){
        return this.gson.toJson(object);
    }

    public Object fromJson(String string, Type type){
        return this.gson.fromJson(string, type);
    }

    public Object fromJson(Reader reader, Type type){
        return this.gson.fromJson(reader, type);
    }

    public Object fromJson(File file, Type type){
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return this.fromJson(reader, type);
    }
}
