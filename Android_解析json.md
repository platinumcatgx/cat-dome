# Android 解析JSON

JSON中,[]代表一个数组,{}代表一个对象

```JSON
[
{"Name":"Duty Free Shop"},
{"Name":"Nike"},
{"Name":"KINGPOWER"},
{"Name":"BENLUX"},
{"Name":"Ctrip"},
{"Name":"lvmama"}
]
```



```java
/**
 * 解析JSON
 */
public void jsonToString(String json) {

        try {
            JSONArray ja = new JSONArray();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = (JSONObject) ja.get(0);
                String str = (String) jo.get("name");
                Log.i("h", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
```

