package org.broadinstitute.ddp;


import java.util.Properties;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.broadinstitute.ddp.controller.PRRouletteController;
import org.broadinstitute.ddp.util.TeamUtil;
import spark.Spark;

public class PRRoulette {

    private static String testTeamPath = "src/resources/team.csv";
    private static String testFoePath = "src/resources/foe.csv";
    private static String testFoeTeamPath = "src/resources/team-to-foe.csv";

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("My application").setMaster("local[2]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        TeamUtil.setFilePaths(testTeamPath, testFoePath, testFoeTeamPath);
        Spark.port(4567);
        Spark.staticFiles.location("/public");
        Spark.staticFiles.expireTime(600L);

        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init( p );
        VelocityContext context = new VelocityContext();
        Template template = Velocity.getTemplate("templates/Hello.vm");

        Spark.get("/", PRRouletteController.servePRPage);
    }
}
