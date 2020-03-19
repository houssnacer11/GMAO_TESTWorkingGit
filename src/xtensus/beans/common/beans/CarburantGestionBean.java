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
import xtensus.services.ApplicationManager;
@Component
@Scope("request")
public class CarburantGestionBean {
	private Carburant carburant;
	//div
	private String divajouter;
	private String divmodifier;
	private String divconsult;
	private String divnonconsult;
	private String titre;
	private String infoChampObligatoir;
	private DataModel listcarburantDM;
	private List<Carburant> listcarburant;
	private List<Carburant> copylistC;
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
	private Carburant car;
	private String copyCarburantlibelle;
	private boolean status4;
	private boolean status5;
	
	@Autowired
	public CarburantGestionBean(
			@Qualifier("applicationManager") ApplicationManager appMgr) {
		this.appMgr = appMgr;
		
		carburant = new Carburant();
		car = new Carburant();
		listcarburantDM = new ListDataModel();
		listcarburant = new ArrayList<Carburant>();
		copylistC = new ArrayList<Carburant>();
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
		titre = "Ajouter carburant";

		listcarburant = new ArrayList<Carburant>();
		try {
			listcarburant = appMgr.getList(Carburant.class);
			Collections.reverse(listcarburant);
			listcarburantDM.setWrappedData(listcarburant);

		} catch (Exception e) {
			System.out.println("erreur");
		}
		

	}

	public void save() {
		status = false;
		status3 = false;

		try {
			appMgr.insert(carburant);

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
		carburant = (Carburant) listcarburantDM.getRowData();
		setStatus4(true);
		
	}
	// Get Selection Rows
	public void getSelectionRow() {

		System.out.println(divajouter);
		System.out.println(divmodifier);
		try {
			carburant = (Carburant) listcarburantDM.getRowData();
	
			System.out.println(carburant.getCarburantLibelle());
			System.out
					.println("*******SelectionCarburantConsulterBean*********");
			Initialize();

		} catch (Exception e) {
			System.out
					.println("*******ErreurDeSelectionCarburantConsulterBean*******");
		}
		divajouter = "none";
		divmodifier = "inline";
		setDivnonconsult("inline");
		setDivconsult("none");
		infoChampObligatoir = "inline";
		titre = "Modification carburant";
		titleaccor = "Modification carburant";
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
		titre = "Consultation carburant";
		titleaccor = "Consultation carburant";
	}
	
	public void updateSelectedRow() {
		status1=false;
		status2=false;
		try {

			appMgr.update(carburant);

			System.out.println("UpdateTerminee");
			status1=true;	
			listcarburant = new ArrayList<Carburant>();
			Initialize();
			carburant = new Carburant();
		} catch (Exception e) {
			status2=true;
		}
		Initialize();

		divajouter = "inline";
		divmodifier = "none";
		infoChampObligatoir = "inline";
		titre = "Ajout carburant";
		titleaccor = "Ajout carburant";

	}

	public void deleteSelectedRow() {
		try {
			System.out.println(carburant);
			appMgr.delete(carburant);
			System.out.println("DeleteTerminee");

		} catch (Exception e) {
			e.printStackTrace();
		}
		listcarburantDM = new ListDataModel();
		listcarburant = new ArrayList<Carburant>();
		copylistC = new ArrayList<Carburant>();
		Initialize();
		hidechamp();
	}

	public void annulModif() {
		carburant = new Carburant();
		divajouter = "inline";
		divmodifier = "none";
		infoChampObligatoir = "inline";
		titre = "Ajout carburant";
		//tran.setTransmissionLibelle("");

	}

	public void viderchamp() {
		carburant = new Carburant();
		
		msgerror = true;
		titleaccor = "Ajout carburant";
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
		if (listcarburantDM == null && listcarburantDM.getWrappedData() == null)
			records = 0;
		else
			records = ((List<Carburant>) listcarburantDM.getWrappedData()).size();
		return records;
	}
	public Carburant getCarburant() {
		return carburant;
	}
	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
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
	public DataModel getlistcarburantDM() {
		return listcarburantDM;
	}
	public void setlistcarburantDM(DataModel listcarburantDM) {
		this.listcarburantDM = listcarburantDM;
	}
	public List<Carburant> getlistcarburant() {
		return listcarburant;
	}
	public void setlistcarburant(List<Carburant> listcarburant) {
		this.listcarburant = listcarburant;
	}
	public List<Carburant> getCopylistC() {
		return copylistC;
	}
	public void setCopylistC(List<Carburant> copylistC) {
		this.copylistC = copylistC;
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
	public Carburant getCar() {
		return car;
	}
	public void setCar(Carburant car) {
		this.car = car;
	}
	public String valide() {
		return ("OK");
	}
	public void setCopyCarburantlibelle(String copyCarburantlibelle) {
		this.copyCarburantlibelle = copyCarburantlibelle;
	}
	public String getCopyCarburantlibelle() {
		return copyCarburantlibelle;
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
