package com.example.demo.graphql;

import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import kotlin.text.Charsets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;

@Component
public class GraphQLProvider {

    private SvcDataFetcher svcDataFetcher;


    @Autowired
    public GraphQLProvider(SvcDataFetcher svcDataFetcher) {
        this.svcDataFetcher = svcDataFetcher;
    }
    private GraphQL graphQL;
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("svc.graphql");      // on tu miał graphqls
        String schemaString = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(schemaString);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
        System.out.println("KEEEEEEEEEEEEEEEEEEK");
    }

    private GraphQLSchema buildSchema(String schemaString) {
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaString);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(queryBuilder())
                .build();
    }

    private TypeRuntimeWiring.Builder queryBuilder() {
        return TypeRuntimeWiring.newTypeWiring("Query")
                .dataFetcher("getAllSvc", svcDataFetcher.getAllSvc())
                .dataFetcher("getSvcById", svcDataFetcher.getSvcById());
    }

}
