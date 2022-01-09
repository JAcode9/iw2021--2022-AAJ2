package com.example.application.views.compra;

import com.example.application.classes.Entrada;
import com.example.application.classes.Pelicula;
import com.example.application.classes.Persona;
import com.example.application.classes.Proyeccion;
import com.example.application.repositories.*;
import com.example.application.security.SecurityUtils;
import com.example.application.views.MainLayout;
import com.example.application.views.addproyeccion.addproyeccionview;
import com.example.application.views.cogesilla.cogesillaview;
import com.example.application.views.imagelist.ImageListView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Secured({"0","1","2"})
@PageTitle("About")
@Route(value = "Compra", layout = MainLayout.class)
public class compraview extends VerticalLayout implements BeforeEnterObserver {

    //private String nom = UI.getCurrent();
    private final String nombresesion = null; //recojo la variable de sesion

    private H2 h = new H2("hola");
    private H2 h2 = new H2("no");
    private H2 h3 = new H2("hola");
    private H2 h4 = new H2("no");
    private int numero_click;
    private int numasientos;
    private int asientos;
    private int columna;
    private int fila;
    private int butacones;
    private int col2;
    private int fil2;
    private LocalDateTime fecha_entrada;
    private int proid;
    private List<Proyeccion> proyecciones;
    private List<Integer> l2 = new ArrayList<Integer>();
    private EntradaService entradaService;
    private PersonaService personaService;
    private ProyeccionService proyeccionService;
    private SecurityUtils securityUtils = new SecurityUtils();
    private final SecurityService securityService;
    private String nombrepersona = "";

    private Proyeccion proyeccion;
    private Persona persona;
    private Entrada entrada;
    private Button save = new Button("Save");


    public compraview(@Autowired EntradaService entradaService, ProyeccionService proyeccionService, SecurityService securityService, PersonaService personaService) {
        this.entradaService = entradaService;
        this.proyeccionService = proyeccionService;
        this.securityService = securityService;
        this.personaService = personaService;
        if(UI.getCurrent().getSession().getAttribute("cont_asientos") != null)
            asientos = (int) UI.getCurrent().getSession().getAttribute("cont_asientos");
        if(UI.getCurrent().getSession().getAttribute("colu") != null)
            columna = (int)UI.getCurrent().getSession().getAttribute("colu");
        if(UI.getCurrent().getSession().getAttribute("fila") != null)
            fila = (int)UI.getCurrent().getSession().getAttribute("fila");
        if(UI.getCurrent().getSession().getAttribute("lista") != null)
            l2 = (List<Integer>) UI.getCurrent().getSession().getAttribute("lista");
        if(UI.getCurrent().getSession().getAttribute("proyid") != null) {
            proyeccion = (Proyeccion) UI.getCurrent().getSession().getAttribute("proyid");
        }
        if(UI.getCurrent().getSession().getAttribute("horapeli") != null)
            fecha_entrada = (LocalDateTime) UI.getCurrent().getSession().getAttribute("horapeli");

        h2.setText("Columna: "+l2);

        UserDetails userLogged;

        userLogged = securityUtils.getAuthenticatedUser();

        persona = personaService.findByUsername(userLogged.getUsername());

        butacones = l2.size() / 2;
        save.addClickListener(e -> {
            for(int i = 0; i<l2.size(); i+=2) {
                entrada = new Entrada();
                entrada.setProyeccion(proyeccion);
                entrada.setFecha_entrada(fecha_entrada);
                entrada.setPersona_ent(persona);
                entrada.setColumna(l2.get(i));
                entrada.setFila(l2.get(i+1));

                entradaService.update(this.entrada);
            }
                Notification.show("Datos de la entrada guardado.");

        });

        setSpacing(false);

        add(h2);
        add(save);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if(UI.getCurrent().getSession().getAttribute("clicks") == null)
            event.forwardTo(ImageListView.class);
        if(UI.getCurrent().getSession().getAttribute("num_asientos") == null)
            event.forwardTo(ImageListView.class);
        if(UI.getCurrent().getSession().getAttribute("lista") == null)
            event.forwardTo(ImageListView.class);

        asientos = (int)UI.getCurrent().getSession().getAttribute("cont_asientos");
        columna = (int)UI.getCurrent().getSession().getAttribute("colu");
        fila = (int)UI.getCurrent().getSession().getAttribute("fila");
        col2 = (int)UI.getCurrent().getSession().getAttribute("colu");
        fil2 = (int)UI.getCurrent().getSession().getAttribute("fila");
        fecha_entrada = (LocalDateTime) UI.getCurrent().getSession().getAttribute("horapeli");
    }

}

