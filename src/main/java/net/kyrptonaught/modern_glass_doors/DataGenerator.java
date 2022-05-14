package net.kyrptonaught.modern_glass_doors;

import java.io.File;
import java.io.FileOutputStream;

public class DataGenerator {
    static String[] woods = {"oak", "spruce", "birch", "acacia", "jungle", "dark_oak", "iron"};
    static String[] types = {"bottom", "open", "top"};

    public static void genModels() {
        for (String type : types)
            for (String wood : woods) {
                File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\modern_glass_doors\\models\\block\\trapdoor\\" + wood + "_glass_trapdoor_" + type + ".json");
                try (FileOutputStream out = new FileOutputStream(file, false)) {
                    if (!file.exists())
                        file.createNewFile();
                    String output = "{\n" +
                            "  \"parent\": \"modern_glass_doors:block/template/template_trapdoor_" + type + "\",\n" +
                            "  \"textures\": {\n" +
                            "    \"texture\": \"modern_glass_doors:block/" + wood + "_glass_trapdoor\",\n" +
                            "    \"texture2\": \"minecraft:block/" + wood + "_trapdoor\"\n" +
                            "  }\n" +
                            "}";
                    out.write(output.getBytes());
                } catch (Exception e) {
                }
            }
    }

    public static void genItemModels() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\assets\\modern_glass_doors\\models\\item\\" + wood + "_glass_trapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"parent\": \"modern_glass_doors:block/trapdoor/" + wood + "_glass_trapdoor_bottom\"\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }

    public static void genRecipes() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\modern_glass_doors\\recipes\\trapdoor\\" + wood + "_glass_trapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"modern_glass_doors:" + wood + "_glass_trapdoor\",\n" +
                        "    \"count\": 1\n" +
                        "  },\n" +
                        "  \"ingredients\": [\n" +
                        "    {\n" +
                        "      \"item\": \"minecraft:" + wood + "_trapdoor\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"item\": \"minecraft:glass_pane\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }

    public static void genRecipesReverse() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\modern_glass_doors\\recipes\\reverse\\trapdoor\\" + wood + "_glass_trapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:crafting_shapeless\",\n" +
                        "  \"result\": {\n" +
                        "    \"item\": \"minecraft:" + wood + "_trapdoor\",\n" +
                        "    \"count\": 1\n" +
                        "  },\n" +
                        "  \"ingredients\": [\n" +
                        "    {\n" +
                        "      \"item\": \"modern_glass_doors:" + wood + "_glass_trapdoor\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }
    public static void genLoot() {
        for (String wood : woods) {
            File file = new File("C:\\Users\\anthony\\Desktop\\Minecraft Mod Dev\\GlassDoor-1.16\\src\\main\\resources\\data\\modern_glass_doors\\loot_tables\\blocks\\" + wood + "_glass_trapdoor.json");
            try (FileOutputStream out = new FileOutputStream(file, false)) {
                if (!file.exists())
                    file.createNewFile();
                String output = "{\n" +
                        "  \"type\": \"minecraft:block\",\n" +
                        "  \"pools\": [\n" +
                        "    {\n" +
                        "      \"rolls\": 1,\n" +
                        "      \"entries\": [\n" +
                        "        {\n" +
                        "          \"type\": \"minecraft:item\",\n" +
                        "          \"name\": \"modern_glass_doors:"+wood+"_glass_trapdoor\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"conditions\": [\n" +
                        "        {\n" +
                        "          \"condition\": \"minecraft:survives_explosion\"\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";
                out.write(output.getBytes());
            } catch (Exception e) {
            }
        }
    }
}
