package enset.tp1;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class GraphQLConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return wiringBuilder -> wiringBuilder
                .scalar(dateTimeScalar());
    }

    private GraphQLScalarType dateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("DateTime")
                .description("Java Timestamp scalar")
                .coercing(new Coercing<Timestamp, String>() {
                    @Override
                    public String serialize(Object input) throws CoercingSerializeException {
                        if (input instanceof Timestamp) {
                            return ((Timestamp) input).toLocalDateTime()
                                    .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                        }
                        throw new CoercingSerializeException("Expected a Timestamp object.");
                    }

                    @Override
                    public Timestamp parseValue(Object input) throws CoercingParseValueException {
                        if (input instanceof String) {
                            LocalDateTime localDateTime = LocalDateTime.parse((String) input,
                                    DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                            return Timestamp.valueOf(localDateTime);
                        }
                        throw new CoercingParseValueException("Expected a String");
                    }

                    @Override
                    public Timestamp parseLiteral(Object input) throws CoercingParseLiteralException {
                        return parseValue(input);
                    }
                })
                .build();
    }
}
