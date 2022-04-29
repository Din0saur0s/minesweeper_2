package sweeper;

import org.json.JSONString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Records extends JFrame {
    private static void parsePlayerObject(JSONObject player)
    {
        JSONObject playerObject = (JSONObject) player.get("player");
        String firstName = (String) playerObject.get("firstName");
        System.out.println(firstName);
        String records = (String) playerObject.get("records");
        System.out.println(records);

    }
    public Records() {
        setTitle("Рекорды");
        setResizable(false);
        setVisible(false);















        pack();
        setLocationRelativeTo(null);
    }
}