package xtensus.beans.common.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import xtensus.entity.Carburant;
import xtensus.entity.Assureur;
import xtensus.services.ApplicationManager;


@Component
@Scope("request")
public class AssureurGestionBean {
	
	private Assureur assureur;
	//div
	private String divajouter;
	private String divmodifier;
	private String divconsult;
	private String divnonconsult;
	private String titre;
	private String infoChampObligatoir;
	private DataModel listassureurDM;
	private List<Assureur> listassureur;
	private List<Assureur> copylistA;
	private long records = 0;
	
	private boolean openaccor;
	private boolean openaccor1;
	private String hidebuttonValidateUser;
	private String hidebuttonDelUpUser;
	private String hideAccor;
	private boolean msgerror;
	private String titleaccor;
	private ApplicationManager appMgr;
	private boolean status;
	private boolean status1;
	private boolean status2;
	private boolean status3;
	private Assureur assu;
	private String copyAssureurlibelle;
	private boolean status4;
	private boolean status5;
	
	@Autowired
	public AssureurGestionBean(
			@Qualifier("applicationManager") ApplicationManager appMgr) {
		this.appMgr = appMgr;
		
		assureur = new Assureur();
		assu = new Assureur();
		listassureurDM = new ListDataModel();
		listassureur = new ArrayList<Assureur>();
		copylistA = new ArrayList<Assureur>();
		openaccor = false;
		openaccor1 = false;
		msgerror = true;
		hidebuttonValidateUser = "inline";
		hidebuttonDelUpUser = "none";
		hideAccor = "none";
		System.out.println("*************Bean Injecte***************");
		divajouter = "inline";
		divmodifier = "none";
		setDivconsult("none");
		setDivnonconsult("inline");
		infoChampObligatoir = "inline";

	}

	@PostConstruct
	public void Initialize() {
		titre = "Ajouter assureur";

		listassureur = new ArrayList<Assureur>();
		try {
			listassureur = appMgr.getList(Assureur.class);
//			Collections.reverse(listassureur);
			listassureurDM.setWrappedData(listassureur);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erreur");
		}
		

	}

	public void save() {
		status = false;
		status3 = false;

		try {
			appMgr.insert(assureur);

			status = true;
			Initialize();
			
			System.out.println("***************Succes***************");

		} catch (Exception e) {
			status3 = true;
			System.out.println("***************Erreur***************");
		}
		
	}

	public void getSelectionRowDel()
	{
		assureur = (Assureur) listassureurDM.getRowData();
		setStatus4(true);
		
	}
	// Get Selection Rows
	public void getSelectionRow() {

		System.out.println(divajouter);
		System.out.println(divmodifier);
		try {
			assureur = (Assureur) listassureurDM.getRowData();
	
			System.out.println(assureur.getAssureurLibelle());
			System.out
					.println("*******SelectionAssureurConsulterBean*********");
			Initialize();

		} catch (Exception e) {
			System.out
					.println("*******ErreurDeSelectionAssureurConsulterBean*******");
		}
		divajouter = "none";
		divmodifier = "inline";
		setDivnonconsult("inline");
		setDivconsult("none");
		infoChampObligatoir = "inline";
		titre = "Modification assureur";
		titleaccor = "Modification assureur";
		openaccor = true;
		openaccor1 = true;
		msgerror = false;
		hideAccor = "inline";
		hidebuttonValidateUser = "none";
		hidebuttonDelUpUser = "inline";
	}
	public void getSelectionRowConst(){
		this.getSelectionRow();
		divmodifier="none";
		setDivnonconsult("none");
		setDivconsult("inline");
		titre = "Consultation assureur";
		titleaccor = "Consultation assureur";
	}
	
	public void updateSelectedRow() {
		status1=false;
		status2=false;
		try {

			appMgr.update(assureur);

			System.out.println("UpdateTerminee");
			status1=true;	
			listassureur = new ArrayList<Assureur>();
			Initialize();
			assureur = new Assureur();
		} catch (Exception e) {
			status2=true;
		}
		Initialize();

		divajouter = "inline";
		divmodifier = "none";
		infoChampObligatoir = "inline";
		titre = "Ajout assureur";
		titleaccor = "Ajout assureur";

	}

	public void deleteSelectedRow() {
		try {
			System.out.println(assureur);
			appMgr.delete(assureur);
			System.out.println("DeleteTerminee");

		} catch (Exception e) {
			e.printStackTrace();
		}
		listassureurDM = new ListDataModel();
		listassureur = new ArrayList<Assureur>();
		copylistA = new ArrayList<Assureur>();
		Initialize();
		hidechamp();
	}

	public void annulModif() {
		assureur = new Assureur();
		divajouter = "inline";
		divmodifier = "none";
		infoChampObligatoir = "inline";
		titre = "Ajout assureur";
		//tran.setTransmissionLibelle("");

	}

	public void viderchamp() {
		assureur = new Assureur();
		
		msgerror = true;
		titleaccor = "Ajout assureur";
		openaccor1 = true;
		openaccor = false;
		hidebuttonDelUpUser = "none";
		hidebuttonValidateUser = "inline";
		hideAccor = "inline";
		divajouter = "inline";
		setDivnonconsult("inline");
		setDivconsult("none");
		divmodifier = "none";
		infoChampObligatoir = "inline";

	}
	
	public void hidechamp(){
	
		hideAccor = "none";
		divajouter = "none";
		setDivnonconsult("none");
		setDivconsult("none");
		divmodifier = "none";
		infoChampObligatoir = "none";
		status=false;
		status1=false;
		status2=false;
		status3=false;
		
		
	}

	// *****************Getters &Setters*******************************
	@SuppressWarnings("unchecked")
	public long getRecords() {
		if (listassureurDM == null && listassureurDM.getWrappedData() == null)
			records = 0;
		else
			records = ((List<Assureur>) listassureurDM.getWrappedData()).size();
		return records;
	}
	public Assureur getAssureur() {
		return assureur;
	}
	public void setAssureur(Assureur assureur) {
		this.assureur = assureur;
	}
	public String getDivajouter() {
		return divajouter;
	}
	public void setDivajouter(String divajouter) {
		this.divajouter = divajouter;
	}
	public String getDivmodifier() {
		return divmodifier;
	}
	public void setDivmodifier(String divmodifier) {
		this.divmodifier = divmodifier;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getInfoChampObligatoir() {
		return infoChampObligatoir;
	}
	public void setInfoChampObligatoir(String infoChampObligatoir) {
		this.infoChampObligatoir = infoChampObligatoir;
	}
	public DataModel getlistassureurDM() {
		return listassureurDM;
	}
	public void setlistassureurDM(DataModel listassureurDM) {
		this.listassureurDM = listassureurDM;
	}
	public List<Assureur> getlistassureur() {
		return listassureur;
	}
	public void setlistassureur(List<Assureur> listassureur) {
		this.listassureur = listassureur;
	}
	public List<Assureur> getCopylistA() {
		return copylistA;
	}
	public void setCopylistA(List<Assureur> copylistA) {
		this.copylistA = copylistA;
	}
	
	public boolean isOpenaccor() {
		return openaccor;
	}
	public void setOpenaccor(boolean openaccor) {
		this.openaccor = openaccor;
	}
	public boolean isOpenaccor1() {
		return openaccor1;
	}
	public void setOpenaccor1(boolean openaccor1) {
		this.openaccor1 = openaccor1;
	}
	public String getHidebuttonValidateUser() {
		return hidebuttonValidateUser;
	}
	public void setHidebuttonValidateUser(String hidebuttonValidateUser) {
		this.hidebuttonValidateUser = hidebuttonValidateUser;
	}
	public String getHidebuttonDelUpUser() {
		return hidebuttonDelUpUser;
	}
	public void setHidebuttonDelUpUser(String hidebuttonDelUpUser) {
		this.hidebuttonDelUpUser = hidebuttonDelUpUser;
	}
	public String getHideAccor() {
		return hideAccor;
	}
	public void setHideAccor(String hideAccor) {
		this.hideAccor = hideAccor;
	}
	public boolean isMsgerror() {
		return msgerror;
	}
	public void setMsgerror(boolean msgerror) {
		this.msgerror = msgerror;
	}
	public String getTitleaccor() {
		return titleaccor;
	}
	public void setTitleaccor(String titleaccor) {
		this.titleaccor = titleaccor;
	}
	public ApplicationManager getAppMgr() {
		return appMgr;
	}
	public void setAppMgr(ApplicationManager appMgr) {
		this.appMgr = appMgr;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isStatus1() {
		return status1;
	}
	public void setStatus1(boolean status1) {
		this.status1 = status1;
	}
	public boolean isStatus2() {
		return status2;
	}
	public void setStatus2(boolean status2) {
		this.status2 = status2;
	}
	public boolean isStatus3() {
		return status3;
	}
	public void setStatus3(boolean status3) {
		this.status3 = status3;
	}
	public Assureur getAssu() {
		return assu;
	}
	public void setAssu(Assureur assu) {
		this.assu = assu;
	}
	public String valide() {
		return ("OK");
	}
	public void setCopyAssureurlibelle(String copyAssureurlibelle) {
		this.copyAssureurlibelle = copyAssureurlibelle;
	}
	public String getCopyAssureurlibelle() {
		return copyAssureurlibelle;
	}

	public String getDivconsult() {
		return divconsult;
	}

	public void setDivconsult(String divconsult) {
		this.divconsult = divconsult;
	}

	public String getDivnonconsult() {
		return divnonconsult;
	}

	public void setDivnonconsult(String divnonconsult) {
		this.divnonconsult = divnonconsult;
	}

	public boolean isStatus4() {
		return status4;
	}

	public void setStatus4(boolean status4) {
		this.status4 = status4;
	}

	public boolean isStatus5() {
		return status5;
	}

	public void setStatus5(boolean status5) {
		this.status5 = status5;
	}
	


}
