import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDelegator {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017/";
    private static final String DATABASE_NAME = "recipe";
    private static final String COLLECTION_NAME = "recipes";

    public static void doInsert(Recipe p_recipe){
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            try {
                InsertOneResult result = collection.insertOne(new Document()
                        .append("name", p_recipe.getName())
                        .append("instructions", p_recipe.getInstructions())
                        .append("ingredientsList", p_recipe.getIngredientList())
                        .append("tagsList", p_recipe.getTagsList()));
                System.out.println("Success! Inserted document id: " + result.getInsertedId());
            } catch (MongoException e) {
                System.err.println("Unable to insert due to an error: " + e);
            }
        }
    }

    public static void getByName(String p_name){
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Document doc = collection.find(Filters.eq("name", p_name)).first(); //TODO: Duplicates?
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    public static List<Document> getBulkByName(String p_name){
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            List<Document> results;
            results = collection.find(Filters.regex("name", ".*" + p_name + ".*", "i")).into(new ArrayList<>());

            if (!results.isEmpty()) {
                System.out.println("We got documents.");
                results.forEach(o -> System.out.println(o.toJson()));
            } else {
                System.out.println("No matching documents found.");
            }
            return results;
        }
    }

    public static void getByInstructions(String p_instructions){
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Document doc = collection.find(Filters.eq("instructions", p_instructions)).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    public static void getByTags(List<String> p_lstTags){
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);
            Document doc = collection.find(Filters.in("tagsList", p_lstTags)).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}
