# Prompt sending for GPT-4 

## Explanation

This service takes JSON-files following the structure below to send the containing prompts to the OpenAI ChatGPT API and write the response back to the file as `gptExplanation`.

```json
{"explanations":[
{
  "testData": {
    "questionID": "questionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8",
    "question": "How many casualties were a result of the Troubles?",
    "componentNumber": 1,
    "annotationTypeAsInt": 2,
    "annotationType": "AnnotationOfRelation",
    "randomComponents": "[LD-Shuyo, DiambiguationProperty]",
    "usedComponent": "DiambiguationProperty",
    "explanation": "The component urn:qanary:DiambiguationProperty has added 1 annotation(s) to the graph and the following relations were found within the origin question: 1. ' http://dbpedia.org/ontology/result ' at 2024-01-14T06:31:40.120045Z ",
    "graphID": "urn:graph:6d7be60b-759c-4b99-b650-f8bdb18dafd1",
    "dataSet": "0.05582524931795208 rdf:type qa:AnnotationOfRelation .\n0.05582524931795208 oa:hasBody http://dbpedia.org/ontology/result .\n0.05582524931795208 oa:annotatedAt 2024-01-14T06:31:40.120045Z .\n0.05582524931795208 oa:hasTarget 48ef825c5bef6047a4b1dec41145b903 .\n0.05582524931795208 oa:annotatedBy urn:qanary:DiambiguationProperty .\n48ef825c5bef6047a4b1dec41145b903 oa:hasSource questionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 .\n48ef825c5bef6047a4b1dec41145b903 rdf:type oa:SpecificResource .\nquestionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 owl:sameAs urn:qanary:currentQuestion .\nquestionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 rdf:type qa:Question .\n",
    "questionNumber": 249
  },
  "gptExplanation": "",
  "prompt": "Given the following context:\nHere, we consider the data of a Question Answering system.\nThe data describes the outcome of this system.\nAs a user I'd like to understand what happened inside that particular component.\nFor this purpose a (text-based) explanation has to be computed.\n\nFor example, the following explanation was created for the question \"questionID:ccae53c7-860a-437b-baac-725773fac805\" from the given raw data.\n\nThe example explanation:\nThe component urn:qanary:FalconRELcomponent-dbpedia has added 3 annotation(s) to the graph and the following relations were found within the origin question: 1. ' http://dbpedia.org/ontology/company ' at 2023-10-25T08:52:57.746528Z  2. ' http://dbpedia.org/ontology/foundingYear ' at 2023-10-25T08:52:57.752887Z  3. ' http://dbpedia.org/ontology/anthem ' at 2023-10-25T08:52:57.758854Z \n\nGiven raw data:\n0.3022417590498188 rdf:type qa:AnnotationOfRelation .\n0.1457955516622381 rdf:type qa:AnnotationOfRelation .\n0.7588830728823706 rdf:type qa:AnnotationOfRelation .\n0.7588830728823706 oa:hasBody http://dbpedia.org/ontology/anthem .\n0.3022417590498188 oa:hasBody http://dbpedia.org/ontology/company .\n0.1457955516622381 oa:hasBody http://dbpedia.org/ontology/foundingYear .\n0.3022417590498188 oa:hasTarget 7487267aebbf4d4b4e4ff2a3083f59ca .\n0.1457955516622381 oa:hasTarget 96ba6c1836f00ea57454e3c8246fa483 .\n0.7588830728823706 oa:hasTarget 5acaed83c5e3072e7dc34fc869ce1d6e .\n0.3022417590498188 oa:annotatedAt 2023-10-25T08:52:57.746528Z .\n0.1457955516622381 oa:annotatedAt 2023-10-25T08:52:57.752887Z .\n0.7588830728823706 oa:annotatedAt 2023-10-25T08:52:57.758854Z .\n0.3022417590498188 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.1457955516622381 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.7588830728823706 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.3022417590498188 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n0.1457955516622381 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n0.7588830728823706 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n7487267aebbf4d4b4e4ff2a3083f59ca rdf:type oa:SpecificResource .\n96ba6c1836f00ea57454e3c8246fa483 rdf:type oa:SpecificResource .\n5acaed83c5e3072e7dc34fc869ce1d6e rdf:type oa:SpecificResource .\n7487267aebbf4d4b4e4ff2a3083f59ca oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\n96ba6c1836f00ea57454e3c8246fa483 oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\n5acaed83c5e3072e7dc34fc869ce1d6e oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\nquestionID:ccae53c7-860a-437b-baac-725773fac805 rdf:type qa:Question .\nquestionID:ccae53c7-860a-437b-baac-725773fac805 owl:sameAs urn:qanary:currentQuestion .\n\n\nAnother example is the following explanation for the question \"questionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88\".\n\nThe example explanation:\nThe component urn:qanary:DiambiguationProperty has added 1 annotation(s) to the graph and the following relations were found within the origin question: 1. ' http://dbpedia.org/property/birthplace ' at 2023-10-25T08:53:03.198513Z \n\nGiven raw data:\n0.999288182239648 rdf:type qa:AnnotationOfRelation .\n0.999288182239648 oa:hasBody http://dbpedia.org/property/birthplace .\n0.999288182239648 oa:hasTarget 79244e01daf368e820b1fd5900e49ea8 .\n0.999288182239648 oa:annotatedAt 2023-10-25T08:53:03.198513Z .\n0.999288182239648 oa:annotatedBy urn:qanary:DiambiguationProperty .\n79244e01daf368e820b1fd5900e49ea8 rdf:type oa:SpecificResource .\n79244e01daf368e820b1fd5900e49ea8 oa:hasSource questionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 .\nquestionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 rdf:type qa:Question .\nquestionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 owl:sameAs urn:qanary:currentQuestion .\n\n\nNow, create an explanation for the following RDF data:\n0.05582524931795208 rdf:type qa:AnnotationOfRelation .\n0.05582524931795208 oa:hasBody http://dbpedia.org/ontology/result .\n0.05582524931795208 oa:annotatedAt 2024-01-14T06:31:40.120045Z .\n0.05582524931795208 oa:hasTarget 48ef825c5bef6047a4b1dec41145b903 .\n0.05582524931795208 oa:annotatedBy urn:qanary:DiambiguationProperty .\n48ef825c5bef6047a4b1dec41145b903 oa:hasSource questionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 .\n48ef825c5bef6047a4b1dec41145b903 rdf:type oa:SpecificResource .\nquestionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 owl:sameAs urn:qanary:currentQuestion .\nquestionID:2fc23e9f-d1e7-47f1-a2bf-79583df0b7c8 rdf:type qa:Question .\n\n\nDon't introduce your answer and only return the result.",
  "exampleData": [
    {
      "questionID": "questionID:ccae53c7-860a-437b-baac-725773fac805",
      "question": "which company is founded later, samsung or sony?",
      "componentNumber": 0,
      "annotationTypeAsInt": 2,
      "annotationType": "AnnotationOfRelation",
      "randomComponents": "[LD-Shuyo, FalconRELcomponent-dbpedia]",
      "usedComponent": "FalconRELcomponent-dbpedia",
      "explanation": "The component urn:qanary:FalconRELcomponent-dbpedia has added 3 annotation(s) to the graph and the following relations were found within the origin question: 1. ' http://dbpedia.org/ontology/company ' at 2023-10-25T08:52:57.746528Z  2. ' http://dbpedia.org/ontology/foundingYear ' at 2023-10-25T08:52:57.752887Z  3. ' http://dbpedia.org/ontology/anthem ' at 2023-10-25T08:52:57.758854Z ",
      "graphID": "urn:graph:6cc16c5e-2100-4c67-a8b2-4d4db1b02546",
      "dataSet": "0.3022417590498188 rdf:type qa:AnnotationOfRelation .\n0.1457955516622381 rdf:type qa:AnnotationOfRelation .\n0.7588830728823706 rdf:type qa:AnnotationOfRelation .\n0.7588830728823706 oa:hasBody http://dbpedia.org/ontology/anthem .\n0.3022417590498188 oa:hasBody http://dbpedia.org/ontology/company .\n0.1457955516622381 oa:hasBody http://dbpedia.org/ontology/foundingYear .\n0.3022417590498188 oa:hasTarget 7487267aebbf4d4b4e4ff2a3083f59ca .\n0.1457955516622381 oa:hasTarget 96ba6c1836f00ea57454e3c8246fa483 .\n0.7588830728823706 oa:hasTarget 5acaed83c5e3072e7dc34fc869ce1d6e .\n0.3022417590498188 oa:annotatedAt 2023-10-25T08:52:57.746528Z .\n0.1457955516622381 oa:annotatedAt 2023-10-25T08:52:57.752887Z .\n0.7588830728823706 oa:annotatedAt 2023-10-25T08:52:57.758854Z .\n0.3022417590498188 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.1457955516622381 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.7588830728823706 oa:annotatedBy urn:qanary:FalconRELcomponent-dbpedia .\n0.3022417590498188 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n0.1457955516622381 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n0.7588830728823706 qa:score 1.0^^http://www.w3.org/2001/XMLSchema#float .\n7487267aebbf4d4b4e4ff2a3083f59ca rdf:type oa:SpecificResource .\n96ba6c1836f00ea57454e3c8246fa483 rdf:type oa:SpecificResource .\n5acaed83c5e3072e7dc34fc869ce1d6e rdf:type oa:SpecificResource .\n7487267aebbf4d4b4e4ff2a3083f59ca oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\n96ba6c1836f00ea57454e3c8246fa483 oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\n5acaed83c5e3072e7dc34fc869ce1d6e oa:hasSource questionID:ccae53c7-860a-437b-baac-725773fac805 .\nquestionID:ccae53c7-860a-437b-baac-725773fac805 rdf:type qa:Question .\nquestionID:ccae53c7-860a-437b-baac-725773fac805 owl:sameAs urn:qanary:currentQuestion .\n",
      "questionNumber": 365
    },
    {
      "questionID": "questionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88",
      "question": "How many inhabitants does the birthplace of Cristiano Ronaldo have?",
      "componentNumber": 1,
      "annotationTypeAsInt": 2,
      "annotationType": "AnnotationOfRelation",
      "randomComponents": "[LD-Shuyo, DiambiguationProperty]",
      "usedComponent": "DiambiguationProperty",
      "explanation": "The component urn:qanary:DiambiguationProperty has added 1 annotation(s) to the graph and the following relations were found within the origin question: 1. ' http://dbpedia.org/property/birthplace ' at 2023-10-25T08:53:03.198513Z ",
      "graphID": "urn:graph:56a4f8e7-473e-482a-b5e5-49833ea40df0",
      "dataSet": "0.999288182239648 rdf:type qa:AnnotationOfRelation .\n0.999288182239648 oa:hasBody http://dbpedia.org/property/birthplace .\n0.999288182239648 oa:hasTarget 79244e01daf368e820b1fd5900e49ea8 .\n0.999288182239648 oa:annotatedAt 2023-10-25T08:53:03.198513Z .\n0.999288182239648 oa:annotatedBy urn:qanary:DiambiguationProperty .\n79244e01daf368e820b1fd5900e49ea8 rdf:type oa:SpecificResource .\n79244e01daf368e820b1fd5900e49ea8 oa:hasSource questionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 .\nquestionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 rdf:type qa:Question .\nquestionID:dc557730-f5a2-4ccc-b69b-3e02700a9d88 owl:sameAs urn:qanary:currentQuestion .\n",
      "questionNumber": 69
    }
  ]
}]
}
```
