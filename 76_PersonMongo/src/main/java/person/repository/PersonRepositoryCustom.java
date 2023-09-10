package person.repository;

import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import person.dto.Person;

import java.util.List;
import java.util.Map;

//CUSTOME AGGREGATE - TEMPLATE MONGO DRIVER
@Repository
public class PersonRepositoryCustom {

    @Autowired
    MongoTemplate template;

    //    READ
    public List<Person> getAll() {
        return template.findAll(Person.class);
    }

    public Person findByNameAndId(String name, int id) {
        Criteria c = Criteria.where("name").is(name).and("id").gt(id);
        Query q = new Query();
        q.addCriteria(c);
        List<Person> temp = template.find(q, Person.class);
        if (temp.isEmpty()) {
            return null;
        }
        return temp.get(0);
    }

    //    DELETE
    public boolean remove(Person p) {
        DeleteResult res = template.remove(p);
        return res.getDeletedCount() > 0;
    }

    public void updatePerson(String name, String key, Object value) {
        Update upd = new Update().update(key, value);
        template.findAndModify(Query.query(Criteria.where("name").is(name)), upd, Person.class);
    }

    //    AGGREGATE
    public void displayGroupByName() {
        TypedAggregation<Person> agg = Aggregation.newAggregation(Person.class, Aggregation.group("name").count().as("count"));
        AggregationResults<Map> addRes = template.aggregate(agg, Map.class);
        List<Map> mapResult = addRes.getMappedResults();
        System.out.println(mapResult);
    }
}
