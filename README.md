
## OneTwoTrip

### Getting Started

To generate Allure Report you should perform following steps:

```bash
git clone https://github.com/katechkakondratieva/onetwotrip.git
cd onetwotrip
$ mvn clean test
```

Report will be generated to `target/site/allure-maven-plugin` folder. To open the report you can use the following command:

```bash
$ allure serve target\allure-results
```


