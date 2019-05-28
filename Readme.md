# account-ms

Account Microservice based on Debasish Gosh's book: Functional and Reactive Domain Modeling

## application

It can be started with `sbt run` ( dev mode ) or `sbt start` ( prod mode ) and it's available at `http://localhost:9000/mybank`

### resources

| verbs  | url                     |
| ------ | ----------------------- |
| GET    | /index                  |

### commands

```
// format code
sbt compile
sbt test:compile

// create .jar
sbt assembly

// generate coverage report
sbt clean coverage test coverageReport
```

## references

### libraries

* [cats]( https://typelevel.org/cats/ )
* [lightbend config]( https://github.com/lightbend/config )
* [scalatest]( http://www.scalatest.org/ )

### plugins

* [assembly]( https://github.com/sbt/sbt-assembly )
* [coverage]( https://github.com/scoverage/sbt-scoverage )
* [play-framework]( https://www.playframework.com/documentation/2.7.x/ScalaHome )
* [scalariform]( https://github.com/sbt/sbt-scalariform )