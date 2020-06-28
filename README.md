***movie-managing-app***

This is Simple Spring boot application that includes the Optimal Movie Selection helper for the Actor based on the input json.
    Technologies and Tools:
    Java 1.8,
    Spring Boot,
    PostMan,
    Lombok,
    Maven,
    GIT

***How to Run the application***

1.clone the application from https://github.com/vikram026/movie-managing-app.git
2.Do MVN clean install and run the application
3. send some input Json using postman and see the result;

Here I have made the things simple.Just to focus on the requirement;



let's assume the input json is :-
POST Method:http://localhost:8999/movie

    {
        "movieList":[	{
                "name":"Bala",
                "startDate":"2020-01-08",
                "endDate":"2020-01-28"

            },
                {
                "name":"Rock",
                "startDate":"2020-01-20",
                "endDate":"2020-01-30"

            },
                {
                "name":"PolicyMaker",
                "startDate":"2020-01-29",
                "endDate":"2020-02-16"
            },
                {
                "name":"Brave",
                "startDate":"2020-02-02",
                "endDate":"2020-02-14"
            },
                {
                "name":"Drive",
                "startDate":"2020-02-10",
                "endDate":"2020-02-18"
            },
                {
                "name":"Race",
                "startDate":"2020-02-15",
                "endDate":"2020-02-28"
            }

        ]
    }

    So OutPut will be the required Movie list along with total amount Actor can earn as max.

    for the above exapmle output will be:

        {
            "amount": 30000000,   //amount actor can earn in a year
            "movies": [
                {
                    "name": "Bala",
                    "startDate": "2020-01-08T00:00:00.000+00:00",
                    "endDate": "2020-01-28T00:00:00.000+00:00"
                },
                {
                    "name": "Brave",
                    "startDate": "2020-02-02T00:00:00.000+00:00",
                    "endDate": "2020-02-14T00:00:00.000+00:00"
                },
                {
                    "name": "Race",
                    "startDate": "2020-02-15T00:00:00.000+00:00",
                    "endDate": "2020-02-28T00:00:00.000+00:00"
                }
            ]
        }

**Note** : Here I recommend to consider 2020 year only.As assignment is considering for 1 yr only.
