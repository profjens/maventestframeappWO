package js_fb5.w_hs.de.testmavenapp.components;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.components.ERXComponent;
import er.extensions.eof.ERXEC;
import er.extensions.formatters.ERXLocalDateFormatter;
import js_fb5.w_hs.model.MeinUser;

public class ZweiteSeite extends ERXComponent {
	
	private static final long serialVersionUID = 1L;
	private EOEditingContext _editingContext;
	private NSArray<MeinUser> uListe;
	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public ERXLocalDateFormatter formatter = new ERXLocalDateFormatter(formatter1, "dd-MM-yyyy");

	  
    public ZweiteSeite(WOContext context) {
        super(context);
        _editingContext = ERXEC.newEditingContext(); 
    }
    public NSArray<MeinUser>getUListe(){
    	uListe = MeinUser.fetchAllMeinUsers(_editingContext);
    	return uListe;
    }
    public MeinUser aUser, aU;
    public WOActionResults addUser() {
    	aUser = MeinUser.createMeinUser(_editingContext);
    	aUser.setVorName("test");
    	return null;
    }
    public WOActionResults selectUser() {
    	aUser = aU;
    	if (aU.myTimeInJava()!=null) {
    		setFerienstartDatum(aUser.myTimeInJava());
    	}
    	return null;
    }
    public WOActionResults save() {
    	aUser.setMyTimeInJava(_ferienstartDatum);
    	aUser.editingContext().saveChanges();
    	return null;
    }
	private LocalDate _ferienstartDatum;
    public LocalDate getFerienstartDatum() {
    	if (aU!=null) {
    		_ferienstartDatum = aU.myTimeInJava();
    	}
    	return _ferienstartDatum;
    }
    public void setFerienstartDatum(LocalDate d) {
    	if (aUser!=null) {
    		_ferienstartDatum = d;
    	}
    }
    public WOActionResults deleteUser() {
    	try {
        	aU.delete();
        	aU.editingContext().saveChanges();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return null;
    }
}