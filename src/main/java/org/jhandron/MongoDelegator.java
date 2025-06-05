package org.jhandron;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDelegator {

    private static final String DATABASE_NAME = "recipe";
    private static final String COLLECTION_NAME = "recipes";

    //TODO: Put in try-catch block
    private static final CodecRegistry pojoCodecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build())
    );

   private static final MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .build();

    public static void doInsert(Recipe p_recipe){
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("name", p_recipe.getName())
                        .append("instructions", p_recipe.getInstructions())
                        .append("ingredients", p_recipe.getIngredients())
                        .append("tags", p_recipe.getTags())
                        .append("relatedRecipeIds", p_recipe.getRelatedRecipeIds()));
                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException e) {
                System.err.println("Unable to insert due to an error: " + e);
            }
        }
    }

    public static Recipe getByName(String p_name){
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Recipe> collection = database.getCollection(COLLECTION_NAME, Recipe.class);

            Recipe recipe = collection.find(Filters.eq("name", p_name)).first(); //TODO: Duplicates?
            if (recipe != null) {
                System.out.println(recipe);
            } else {
                System.out.println("No matching documents found.");
            }
            return recipe;
        }
    }

    public static Collection<Recipe> getCollectionByName(String p_name) {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Recipe> collection = database.getCollection(COLLECTION_NAME, Recipe.class);

            List<Recipe> results = collection.find(Filters.regex("name", ".*" + p_name + ".*", "i")).into(new ArrayList<>());

            if (!results.isEmpty()) {
                System.out.println("We got documents.");
                results.forEach(o -> System.out.println(o.toString()));
            } else {
                System.out.println("No matching documents found.");
            }
            return results;

        }
    }

    public static Recipe getByInstructions(String p_instructions){
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Recipe> collection = database.getCollection(COLLECTION_NAME, Recipe.class);
            Recipe recipe = collection.find(Filters.eq("instructions", p_instructions)).first(); //TODO:Duplicates
            if (recipe != null) {
                System.out.println(recipe.toString());
            } else {
                System.out.println("No matching documents found.");
            }
            return recipe;
        }
    }

    public static void getByTags(List<String> p_lstTags){
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Recipe> collection = database.getCollection(COLLECTION_NAME, Recipe.class);
            Recipe recipe = collection.find(Filters.in("tagsList", p_lstTags)).first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
        }
    }
}
