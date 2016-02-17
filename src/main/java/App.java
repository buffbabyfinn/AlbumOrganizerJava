import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("albums", request.session().attribute("albums"));

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      model.put("albums", Album.all());
      model.put("template", "templates.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("albums/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/title-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String title = request.queryParams("title");
      Album newAlbum = new Album(title);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

    get("/albums/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Album album = Album.find(Integer.parseInt(request.params(":id")));
      model.put("album", album);
      model.put("template", "templates/album.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
