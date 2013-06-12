package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.Json._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def api = Action {
    Ok(
      Json.toJson(
        Map(
          "simple" -> toJson("api"),
          "testing" -> toJson("jsroutes")
        )
      )
    )
  }

  def javascriptRoutes = Action { implicit request =>
    import routes.javascript._
    Ok(
      Routes.javascriptRouter("jsRoutes")(
        controllers.routes.javascript.Application.api
      )
    ).as(JAVASCRIPT)
  }
}