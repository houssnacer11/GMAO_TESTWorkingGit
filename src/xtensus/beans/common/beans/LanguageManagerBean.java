package xtensus.beans.common.beans;

import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("languageManager")
@Scope(value="session")
public class LanguageManagerBean {
	 private String locale;
	 private String currentLocation;
	 private boolean statusFormFr = true;
	 private boolean statusFormAr = false;
	
	public LanguageManagerBean() {
		locale="fr_FR";
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	 
	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	public String changeLanguage() {
		return currentLocation;
	}
    //this method extract the language parameter and the country parameter
	public Locale createLocal()
	{
	   String[]localParametre=locale.split("_");
	   Locale newLocale=new Locale(localParametre[0], localParametre[1]);
	   return(newLocale);
	
	}

	public void setStatusFormFr(boolean statusFormFr) {
		this.statusFormFr = statusFormFr;
	}

	public boolean isStatusFormFr() {
		return statusFormFr;
	}

	public void setStatusFormAr(boolean statusFormAr) {
		this.statusFormAr = statusFormAr;
	}

	public boolean isStatusFormAr() {
		return statusFormAr;
	}
	
	
}
