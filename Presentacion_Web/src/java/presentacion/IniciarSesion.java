/*
 * IniciarSesion.java
 *
 * Created on 30-mar-2008, 17:37:28
 */
 
package presentacion;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.HiddenField;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.TextField;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @author acactown
 */
public class IniciarSesion extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }
    private Button button1 = new Button();

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button b) {
        this.button1 = b;
    }
    private Button button2 = new Button();

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button b) {
        this.button2 = b;
    }
    private Button button3 = new Button();

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button b) {
        this.button3 = b;
    }
    private Button button4 = new Button();

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button b) {
        this.button4 = b;
    }
    private Button button5 = new Button();

    public Button getButton5() {
        return button5;
    }

    public void setButton5(Button b) {
        this.button5 = b;
    }
    private Button button6 = new Button();

    public Button getButton6() {
        return button6;
    }

    public void setButton6(Button b) {
        this.button6 = b;
    }
    private Button button7 = new Button();

    public Button getButton7() {
        return button7;
    }

    public void setButton7(Button b) {
        this.button7 = b;
    }
    private Button button8 = new Button();

    public Button getButton8() {
        return button8;
    }

    public void setButton8(Button b) {
        this.button8 = b;
    }
    private Button button9 = new Button();

    public Button getButton9() {
        return button9;
    }

    public void setButton9(Button b) {
        this.button9 = b;
    }
    private Button actividad = new Button();

    public Button getActividad() {
        return actividad;
    }

    public void setActividad(Button b) {
        this.actividad = b;
    }
    private TextField password = new TextField();

    public TextField getPassword() {
        return password;
    }

    public void setPassword(TextField tf) {
        this.password = tf;
    }
    private HiddenField campoTemporal = new HiddenField();

    public HiddenField getCampoTemporal() {
        return campoTemporal;
    }

    public void setCampoTemporal(HiddenField hf) {
        this.campoTemporal = hf;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public IniciarSesion() {
        campoTemporal.setText("");
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public void validarClave(String digito){
        campoTemporal.setText(String.valueOf(campoTemporal.getText()) + digito);
        String clave = String.valueOf(campoTemporal.getText());
        switch(clave.length()){
            case 1:
                  password.setText("      *");  
                  actividad.setText("Reset");
            break;
            case 2:
                  password.setText("      **");  
                  actividad.setText("Reset");
            break;
            case 3:
                  password.setText("     ***");
                  actividad.setText("Reset");
            break;
            case 4:
                  password.setText("     ****");
                  actividad.setText("OK");
            break;
            default:
                password.setText("");
                campoTemporal.setText("");
                actividad.setText("Reset");
                validarClave(digito);
            break;

        }
    }
    
    public String button1_action() {
        validarClave("1");
        return null;
    }

    public String actividad_action() {
        String accion = String.valueOf( actividad.getText());
        if(accion.equals("OK")){
            boolean valido = true;
            if(valido){
                
                return "llamarMesero";
            }
        }
        password.setText("");
        campoTemporal.setText("");
        actividad.setText("Reset");
        return null;
    }

    public String button2_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("2");
        return null;
    }

    public String button3_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("3");
        return null;
    }

    public String button4_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("4");
        return null;
    }

    public String button5_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("5");
        return null;
    }

    public String button6_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("6");
        return null;
    }

    public String button7_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("7");
        return null;
    }

    public String button8_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("8");
        return null;
    }

    public String button9_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        validarClave("9");
        return null;
    }

}

