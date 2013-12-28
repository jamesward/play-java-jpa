package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Bar;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static play.libs.Json.toJson;

public class Application extends Controller {
    
    public static Result index() {
        return ok(index.render(Form.form(Bar.class)));
    }

    @Transactional
    public static Result addBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        Bar bar = form.get();
        JPA.em().persist(bar);
        return redirect(controllers.routes.Application.index());
    }

    @Transactional(readOnly = true)
    public static Result listBars() {
        CriteriaBuilder cb = JPA.em().getCriteriaBuilder();
        CriteriaQuery<Bar> cq = cb.createQuery(Bar.class);
        Root<Bar> root = cq.from(Bar.class);
        CriteriaQuery<Bar> all = cq.select(root);
        TypedQuery<Bar> allQuery = JPA.em().createQuery(all);
        JsonNode jsonNodes = toJson(allQuery.getResultList());
        return ok(jsonNodes);
    }
    
}
