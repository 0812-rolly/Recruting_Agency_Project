package com.example.View;

import com.example.DAL.Model.*;
import com.example.Controllers.*;
import com.example.Util.JsonConverter;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Interaction implements Views {

    private Scanner input = new Scanner(System.in);
    private final AdminController adminController = new AdminController();
    private final ApplicantController applicantController = new ApplicantController();
    private final CompanyController companyController = new CompanyController();
    private final EducationController educationController = new EducationController();
    private final EducationInstitutionController educationInstitutionController = new EducationInstitutionController();
    private final EmployerCompanyController employerCompanyController = new EmployerCompanyController();
    private final LaborHistoryController laborHistoryController = new LaborHistoryController();
    private final ManagerController managerController = new ManagerController();
    private final RecrutingAgencyController recrutingAgencyController = new RecrutingAgencyController();
    private final VacancyController vacancyController = new VacancyController();
    private final WorkContractController workContractController = new WorkContractController();

    @Override
    public void displayLoginPage() {
        boolean show = true;
        String email = "";
        String password = "";
        while(show){
            System.out.println("----------------------------------------------------------");
            System.out.println("Enter login and password in one line separated by a space: ");
            System.out.println("----------------------------------------------------------");

            String[] loginAndPass = input.nextLine().split(" ");

            boolean result = adminController.checkLogin(loginAndPass[0], loginAndPass[1]);

            if (result){
                System.out.println("Login successful.");
                break;
            }
            else
                System.out.println("Error: Wrong login or password.");
        }

        displayMenuPage();
    } //готово

    @Override
    public void displayMenuPage() {
        boolean show = true;

        while (show) {
            System.out.println("------------- MENU -------------");
            System.out.println("Choose a table to work with:");
            System.out.println("1. Recruting agency");
            System.out.println("2. Employer company");
            System.out.println("3. Manager");
            System.out.println("4. Applicant");
            System.out.println("5. Vacancy");
            System.out.println("6. Work contract");
            System.out.println("7. Labor history");
            System.out.println("8. Company");
            System.out.println("9. Education");
            System.out.println("10. Education institution");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");

            int option = Integer.parseInt(input.nextLine());

            switch (option) {
                case (1):
                    displayRecrutingAgencyPage();
                    break;
                case (2):
                    displayEmployerCompanyPage();
                    break;
                case (3):
                    displayManagerPage();
                    break;
                case (4):
                    displayApplicantPage();
                    break;
                case (5):
                    displayVacancyPage();
                    break;
                case (6):
                    displayWorkContractPage();
                    break;
                case (7):
                    displayLaborHistoryPage();
                    break;
                case (8):
                    displayCompanyPage();
                    break;
                case (9):
                    displayEducationPage();
                    break;
                case (10):
                    displayEducationInstitutionPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    System.out.println("You should choose a table.");
                    break;
            }
        }
    }  //готово

    @Override
    public void displayApplicantPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- APPLICANT PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all applicants");
            System.out.println("    2. Show applicant by id");
            System.out.println("    3. Show applicant by pasport number");
            System.out.println("    4. Show applicant by phone number");
            System.out.println("    5. Show applicant by required position");
            System.out.println("    6. Add applicant");
            System.out.println("    7. Delete applicant");
            System.out.println("    8. Edit applicant");
            System.out.println("    0. Main menu");
            System.out.println("   ------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllApplicantPage();
                    break;
                case (2):
                    displayApplicantByIdPage();
                    break;
                case (3):
                    displayApplicantByPasportPage();
                    break;
                case (4):
                    displayApplicantByPhonePage();
                    break;
                case (5):
                    displayApplicantByPositionPage();
                    break;
                case (6):
                    displayAddApplicantPage();
                    break;
                case (7):
                    displayDeleteApplicantPage();
                    break;
                case (8):
                    displayEditApplicantPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }  //готово

    @Override
    public void displayCompanyPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- COMPANY PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all companies");
            System.out.println("    2. Show company by id");
            System.out.println("    3. Show company by name");
            System.out.println("    4. Show companies by city");
            System.out.println("    5. Add applicant");
            System.out.println("    6. Delete applicant");
            System.out.println("    7. Edit applicant");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllCompanyPage();
                    break;
                case (2):
                    displayCompanyByIdPage();
                    break;
                case (3):
                    displayCompanyByNamePage();
                    break;
                case (4):
                    displayCompanyByCityPage();
                    break;
                case (5):
                    displayAddCompanyPage();
                    break;
                case (6):
                    displayDeleteCompanyPage();
                    break;
                case (7):
                    displayEditCompanyPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }  //готово

    @Override
    public void displayEducationPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- EDUCATION PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all education");
            System.out.println("    2. Show education by id");
            System.out.println("    3. Add education");
            System.out.println("    4. Delete education");
            System.out.println("    0. Main menu");
            System.out.println("   ------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllEducationPage();
                    break;
                case (2):
                    displayEducationByIdPage();
                    break;
                case (3):
                    displayAddEducationPage();
                    break;
                case (4):
                    displayDeleteEducationPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayEducationInstitutionPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- EDUCATION INSTITUTION PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all education institutions");
            System.out.println("    2. Show education institution by id");
            System.out.println("    3. Show education institutions by city");
            System.out.println("    4. Add education institution");
            System.out.println("    5. Delete education institution");
            System.out.println("    6. Edit education institution");
            System.out.println("    0. Main menu");
            System.out.println("   ------------------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllEducationInstitution();
                    break;
                case (2):
                    displayEducationInstitutionByIdPage();
                    break;
                case (3):
                    displayEducationInstitutionByCityPage();
                    break;
                case (4):
                    displayAddEducationInstitutionPage();
                    break;
                case (5):
                    displayDeleteEducationInstitutionPage();
                    break;
                case (6):
                    displayEditEducationInstitutionPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayEmployerCompanyPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- EMPLOYER COMPANY PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all employer companies");
            System.out.println("    2. Show employer company by id");
            System.out.println("    3. Show employer company by name");
            System.out.println("    4. Show employer company by city");
            System.out.println("    5. Add employer company");
            System.out.println("    6. Delete employer company");
            System.out.println("    7. Edit employer company");
            System.out.println("    0. Main menu");
            System.out.println("   -------------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllEmployerCompanyPage();
                    break;
                case (2):
                    displayEmployerCompanyByIdPage();
                    break;
                case (3):
                    displayEmployerCompanyByNamePage();
                    break;
                case (4):
                    displayEmployerCompanyByCityPage();
                    break;
                case (5):
                    displayAddEmployerCompanyPage();
                    break;
                case (6):
                    displayDeleteEmployerCompanyPage();
                    break;
                case (7):
                    displayEditEmployerCompanyPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayLaborHistoryPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- LABOR HISTORY PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all labor histories");
            System.out.println("    2. Show labor history by id");
            System.out.println("    3. Add labor history");
            System.out.println("    4. Delete labor history");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllLaborHistoryPage();
                    break;
                case (2):
                    displayLaborHistoryByIdPage();
                    break;
                case (3):
                    displayAddLaborHistoryPage();
                    break;
                case (4):
                    displayDeleteLaborHistoryPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayManagerPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- MANAGER PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all managers");
            System.out.println("    2. Show manager by id");
            System.out.println("    3. Add manager");
            System.out.println("    4. Delete manager");
            System.out.println("    5. Edit manager");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllManagerPage();
                    break;
                case (2):
                    displayManagerByIdPage();
                    break;
                case (3):
                    displayAddManagerPage();
                    break;
                case (4):
                    displayDeleteManagerPage();
                    break;
                case (5):
                    displayEditManagerPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayRecrutingAgencyPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- RECRUTING AGENCY PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all agencies");
            System.out.println("    2. Show agency by id");
            System.out.println("    3. Add agency");
            System.out.println("    4. Delete agency");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllRecrutingAgencyPage();
                    break;
                case (2):
                    displayRecrutingAgencyByIdPage();
                    break;
                case (3):
                    displayAddRecrutingAgencyPage();
                    break;
                case (4):
                    displayDeleteRecrutingAgencyPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayVacancyPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- VACANCY PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all vacancies");
            System.out.println("    2. Show vacancy by id");
            System.out.println("    3. Show vacancies by proposed position");
            System.out.println("    4. Add vacancy");
            System.out.println("    5. Delete vacancy");
            System.out.println("    6. Edit vacancy");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllVacancyPage();
                    break;
                case (2):
                    displayVacancyByIdPage();
                    break;
                case (3):
                    displayVacancyByPositionPage();
                    break;
                case (4):
                    displayAddVacancyPage();
                    break;
                case (5):
                    displayDeleteVacancyPage();
                    break;
                case (6):
                    displayEditVacancyPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void displayWorkContractPage() {
        boolean show = true;

        while (show) {
            System.out.println("   ------------- WORK CONTRACT PAGE -------------");
            System.out.println("    Choose an option below:");
            System.out.println("    1. Show all work contracts");
            System.out.println("    2. Show work contract by id");
            System.out.println("    3. Add work contract");
            System.out.println("    4. Delete work contract");
            System.out.println("    5. Edit work contract");
            System.out.println("    0. Main menu");
            System.out.println("   ----------------------------------------------");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option) {
                case (1):
                    displayAllWorkContractPage();
                    break;
                case (2):
                    displayWorkContractByIdPage();
                    break;
                case (3):
                    displayAddWorkContractPage();
                    break;
                case (4):
                    displayDeleteWorkContractPage();
                    break;
                case (5):
                    displayEditWorkContractPage();
                    break;
                case (0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }


//<editor-fold desc="Applicant display block">

    private void displayAllApplicantPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All applicants:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Applicant> applicants = applicantController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(applicants));
    }

    private void displayApplicantByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter applicant id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        Applicant applicant = applicantController.getById(Id);

        if (applicant != null)
            System.out.println(JsonConverter.getConvertedToJson(applicant));
        else
            System.out.println("No applicant with such ID.");
    }

    private void displayApplicantByPasportPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter applicant pasport number: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String pasportNumber = input.nextLine();
        Applicant applicant = applicantController.getByPasportNumber(pasportNumber);

        if (applicant != null)
            System.out.println(JsonConverter.getConvertedToJson(applicant));
        else
            System.out.println("No applicant with such pasport number.");
    }

    private void displayApplicantByPhonePage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter applicant phone number: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String phoneNumber = input.nextLine();
        Applicant applicant = applicantController.getByPhoneNumber(phoneNumber);
        if (applicant != null)
            System.out.println(JsonConverter.getConvertedToJson(applicant));
        else
            System.out.println("No applicant with such phone number.");
    }

    private void displayApplicantByPositionPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter required position: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String reqPosition = input.nextLine();
        List<Applicant> applicant = applicantController.getByReqPosition(reqPosition);
        if (applicant != null)
            System.out.println(JsonConverter.getConvertedToJson(applicant));
        else
            System.out.println("No applicant with such required position.");
    }

    private void displayDeleteApplicantPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of an applicant to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this applicant? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = applicantController.deleteApplicant(Id);
                    if (result)
                        System.out.println("Applicant successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid applicant id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddApplicantPage() {
        String surname;
        String name;
        String patronymic;
        String phoneNumber;
        String gender;
        Integer age;
        String city;
        String addres;
        String pasportNumber;
        String inn;
        String snils;
        String requiredPosition;
        Integer requiredSalary;
        String workShedule;
        Date applicationDate;
        String applicationStatus;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter applicant surname:");
        surname = input.nextLine();
        System.out.println("2. Enter applicant name:");
        name = input.nextLine();
        System.out.println("3. Enter applicant patronymic:");
        patronymic = input.nextLine();
        System.out.println("4. Enter applicant phone number:");
        phoneNumber = input.nextLine();
        System.out.println("5. Enter applicant gender:");
        gender = input.nextLine();
        System.out.println("6. Enter applicant age:");
        age = Integer.parseInt(input.nextLine());
        System.out.println("7. Enter applicant city:");
        city = input.nextLine();
        System.out.println("8. Enter applicant addres:");
        addres = input.nextLine();
        System.out.println("9. Enter applicant pasport number:");
        pasportNumber = input.nextLine();
        System.out.println("10. Enter applicant INN:");
        inn = input.nextLine();
        System.out.println("11. Enter applicant SNILS:");
        snils = input.nextLine();
        System.out.println("12. Enter applicant required position:");
        requiredPosition = input.nextLine();
        System.out.println("13. Enter applicant required salary:");
        requiredSalary = Integer.parseInt(input.nextLine());
        System.out.println("14. Enter applicant work shedule:");
        workShedule = input.nextLine();
        System.out.println("15. Enter applicant application date:");
        applicationDate = Date.valueOf(input.nextLine());
        System.out.println("16. Enter applicant application status:");
        applicationStatus = input.nextLine();

        applicantController.addApplicant(surname, name, patronymic, phoneNumber, gender, age, city, addres,
                pasportNumber, inn, snils, requiredPosition, requiredSalary, workShedule, applicationDate, applicationStatus);
        System.out.println("Applicant added successfully.");
    }

    private void displayEditApplicantPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of an applicant to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (applicantController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No applicant with such id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change applicant phone number");
            System.out.println("   2. Change applicant application status");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeApplicantPhone(Id);
                    break;
                case(2):
                    displayChangeApplicationStatus(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeApplicantPhone(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new phone number of the applicant:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newPhoneNumber = input.nextLine();
        applicantController.updateApplPhoneNumber(Id, newPhoneNumber);
        System.out.println("Applicant update successful.");
    }

    private void displayChangeApplicationStatus(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter 'open' or 'close' application status:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newApplicationStatus = input.nextLine();
        applicantController.updateApplicationStatus(Id, newApplicationStatus);
        System.out.println("Applicant update successful.");
    }

//</editor-fold>

//<editor-fold desc="Company display block">

    private void displayAllCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All companies:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Company> companies = companyController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(companies));
    }

    private void displayCompanyByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter company Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        Company company = companyController.getById(Id);

        if (company != null)
            System.out.println(JsonConverter.getConvertedToJson(company));
        else
            System.out.println("No company with such Id.");
    }

    private void displayCompanyByNamePage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter company name: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String name = input.nextLine();
        Company company = companyController.getByName(name);

        if (company != null)
            System.out.println(JsonConverter.getConvertedToJson(company));
        else
            System.out.println("No company with such name.");
    }

    private void displayCompanyByCityPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter city: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String city = input.nextLine();
        List<Company> companies = companyController.getByCity(city);
        if (companies != null)
            System.out.println(JsonConverter.getConvertedToJson(companies));
        else
            System.out.println("No companies in such city.");
    }

    private void displayDeleteCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a company to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this company? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = companyController.deleteCompany(Id);
                    if (result)
                        System.out.println("Company successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid company Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddCompanyPage() {
        String name;
        String city;
        String addres;
        String phoneNumber;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter company name:");
        name = input.nextLine();
        System.out.println("2. Enter company city:");
        city = input.nextLine();
        System.out.println("3. Enter company addres:");
        addres = input.nextLine();
        System.out.println("4. Enter company phone number:");
        phoneNumber = input.nextLine();


        companyController.addCompany(name, city, addres, phoneNumber);
        System.out.println("Company added successfully.");
    }

    private void displayEditCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of a company to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (companyController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No company with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change company phone number");
            System.out.println("   2. Change company addres");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeCompanyPhone(Id);
                    break;
                case(2):
                    displayChangeCompanyAddres(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeCompanyPhone(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new phone number of the company:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newPhoneNumber = input.nextLine();
        companyController.updateCompPhoneNumber(Id, newPhoneNumber);
        System.out.println("Company update successful.");
    }

    private void displayChangeCompanyAddres(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new addres of the company:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newAddres = input.nextLine();
        companyController.updateCompAddres(Id, newAddres);
        System.out.println("Company update successful.");
    }
//</editor-fold>

//<editor-fold desc="Education display block">

    private void displayAllEducationPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All educations:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Education> educations = educationController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(educations));
    }

    private void displayEducationByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter education id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        Education education = educationController.getById(Id);

        if (education != null)
            System.out.println(JsonConverter.getConvertedToJson(education));
        else
            System.out.println("No education with such ID.");
    }

    private void displayDeleteEducationPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of an education to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this education? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = educationController.deleteEducation(Id);
                    if (result)
                        System.out.println("Education successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid education id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddEducationPage() {
        Long educationInstitution;
        Long applicant;
        String faculty;
        String specialty;
        String typeOfDocument;
        Integer startDate;
        Integer endDate;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter education institution Id:");
        educationInstitution = Long.parseLong(input.nextLine());
        System.out.println("2. Enter applicant Id:");
        applicant = Long.parseLong(input.nextLine());
        System.out.println("3. Enter faculty:");
        faculty = input.nextLine();
        System.out.println("4. Enter spesialty:");
        specialty = input.nextLine();
        System.out.println("5. Enter type of document:");
        typeOfDocument = input.nextLine();
        System.out.println("6. Enter start date:");
        startDate = Integer.parseInt(input.nextLine());
        System.out.println("7. Enter end date:");
        endDate = Integer.parseInt(input.nextLine());


        educationController.addEducation(educationInstitution, applicant, faculty, specialty,
                typeOfDocument, startDate, endDate);
        System.out.println("Education added successfully.");
    }

//</editor-fold>

//<editor-fold desc="Education institution display block">

    private void displayAllEducationInstitution() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All education institutions:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<EducationInstitution> educationInstitutions = educationInstitutionController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(educationInstitutions));
    }

    private void displayEducationInstitutionByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter education institution Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        EducationInstitution educationInstitution = educationInstitutionController.getById(Id);

        if (educationInstitution != null)
            System.out.println(JsonConverter.getConvertedToJson(educationInstitution));
        else
            System.out.println("No education institution with such Id.");
    }

    private void displayEducationInstitutionByCityPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter city: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String city = input.nextLine();
        List<EducationInstitution> educationInstitutions = educationInstitutionController.getByCity(city);
        if (educationInstitutions != null)
            System.out.println(JsonConverter.getConvertedToJson(educationInstitutions));
        else
            System.out.println("No education institutions in such city.");
    }

    private void displayAddEducationInstitutionPage() {
        String name;
        String city;
        String addres;
        String phoneNumber;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter education institution name:");
        name = input.nextLine();
        System.out.println("2. Enter education institution city:");
        city = input.nextLine();
        System.out.println("3. Enter education institution addres:");
        addres = input.nextLine();
        System.out.println("4. Enter education institution phone number:");
        phoneNumber = input.nextLine();


        educationInstitutionController.addEdInst(name, city, addres, phoneNumber);
        System.out.println("Education institution added successfully.");
    }

    private void displayDeleteEducationInstitutionPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of a education institution to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this education institution? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = educationInstitutionController.deleteEdInst(Id);
                    if (result)
                        System.out.println("Education institution successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid education institution Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayEditEducationInstitutionPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of a education institution to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (companyController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No education institution with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change education institution phone number");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeEdInstPhone(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeEdInstPhone(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new phone number of the education institution:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newPhoneNumber = input.nextLine();
        educationInstitutionController.updateEdInstPhoneNumber(Id, newPhoneNumber);
        System.out.println("Education institution update successful.");
    }


//</editor-fold>

//<editor-fold desc="Employer company display block">

    private void displayAllEmployerCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All employer companies:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<EmployerCompany> employerCompanies = employerCompanyController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(employerCompanies));
    }

    private void displayEmployerCompanyByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter employer company Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        EmployerCompany employerCompany = employerCompanyController.getById(Id);

        if (employerCompany != null)
            System.out.println(JsonConverter.getConvertedToJson(employerCompany));
        else
            System.out.println("No employer company with such Id.");
    }

    private void displayEmployerCompanyByNamePage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter employer company name: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String name = input.nextLine();
        EmployerCompany employerCompany = employerCompanyController.getByName(name);

        if (employerCompany != null)
            System.out.println(JsonConverter.getConvertedToJson(employerCompany));
        else
            System.out.println("No employer company with such name.");
    }

    private void displayEmployerCompanyByCityPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter city: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String city = input.nextLine();
        List<EmployerCompany> employerCompanies = employerCompanyController.getByCity(city);
        if (employerCompanies != null)
            System.out.println(JsonConverter.getConvertedToJson(employerCompanies));
        else
            System.out.println("No employer companies in such city.");
    }

    private void displayDeleteEmployerCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a employer company to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this employer company? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = employerCompanyController.deleteCompany(Id);
                    if (result)
                        System.out.println("Employer company successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid employer company Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddEmployerCompanyPage() {
        String name;
        String city;
        String addres;
        String phoneNumber;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter employer company name:");
        name = input.nextLine();
        System.out.println("2. Enter employer company city:");
        city = input.nextLine();
        System.out.println("3. Enter employer company addres:");
        addres = input.nextLine();
        System.out.println("4. Enter employer company phone number:");
        phoneNumber = input.nextLine();


        employerCompanyController.addEmpComp(name, city, addres, phoneNumber);
        System.out.println("Employer company added successfully.");
    }

    private void displayEditEmployerCompanyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of an employer company to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (employerCompanyController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No employer company with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change employer company phone number");
            System.out.println("   2. Change employer company addres");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeEmployerCompanyPhone(Id);
                    break;
                case(2):
                    displayChangeEmployerCompanyAddres(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeEmployerCompanyPhone(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new phone number of the employer company:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newPhoneNumber = input.nextLine();
        employerCompanyController.updateEmpCompPhoneNumber(Id, newPhoneNumber);
        System.out.println("Employer company update successful.");
    }

    private void displayChangeEmployerCompanyAddres(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new addres of the employer company:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newAddres = input.nextLine();
        employerCompanyController.updateEmpCompAddres(Id, newAddres);
        System.out.println("Employer company update successful.");
    }

//</editor-fold>

//<editor-fold desc="Labor history display block">

    private void displayAllLaborHistoryPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All labor histories:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<LaborHistory> laborHistories = laborHistoryController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(laborHistories));
    }

    private void displayLaborHistoryByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter labor history id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        LaborHistory laborHistory = laborHistoryController.getById(Id);

        if (laborHistory != null)
            System.out.println(JsonConverter.getConvertedToJson(laborHistory));
        else
            System.out.println("No labor history with such Id.");
    }

    private void displayDeleteLaborHistoryPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of an labor history to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this labor history? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = laborHistoryController.deleteLaborHistory(Id);
                    if (result)
                        System.out.println("Labor history successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid labor history Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddLaborHistoryPage() {
        Long applicant;
        Long company;
        String position;
        Integer experience;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter applicant Id:");
        applicant = Long.parseLong(input.nextLine());
        System.out.println("2. Enter company Id:");
        company = Long.parseLong(input.nextLine());
        System.out.println("3. Enter position:");
        position = input.nextLine();
        System.out.println("4. Enter experience:");
        experience = Integer.parseInt(input.nextLine());

        laborHistoryController.addLaborHistory(applicant, company, position, experience);
        System.out.println("Labor history added successfully.");
    }

//</editor-fold>

//<editor-fold desc="Manager display block">

    private void displayAllManagerPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All managers:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Manager> managers = managerController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(managers));
    }

    private void displayManagerByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter manager Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        Manager manager = managerController.getById(Id);

        if (manager != null)
            System.out.println(JsonConverter.getConvertedToJson(manager));
        else
            System.out.println("No manager with such Id.");
    }

    private void displayAddManagerPage() {
        Long recrutingAgency;
        String surname;
        String name;
        String patronymic;
        String phoneNumber;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter recruting agency Id:");
        recrutingAgency = Long.parseLong(input.nextLine());
        System.out.println("2. Enter manager surname:");
        surname = input.nextLine();
        System.out.println("3. Enter manager name:");
        name = input.nextLine();
        System.out.println("4. Enter manager patronymic:");
        patronymic = input.nextLine();
        System.out.println("5. Enter company phone number:");
        phoneNumber = input.nextLine();


        managerController.addManager(recrutingAgency, surname, name, patronymic, phoneNumber);
        System.out.println("Manager added successfully.");
    }


    private void displayDeleteManagerPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a manager to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this manager? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = managerController.deleteManager(Id);
                    if (result)
                        System.out.println("Manager successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid manager Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayEditManagerPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of a manager to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (companyController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No manager with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change manager phone number");
            System.out.println("   2. Change manager recruting agency");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeManagerPhone(Id);
                    break;
                case(2):
                    displayChangeManagerRecAg(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeManagerPhone(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new phone number of the manager:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newPhoneNumber = input.nextLine();
        managerController.updateManagerPhoneNumber(Id, newPhoneNumber);
        System.out.println("Manager update successful.");
    }

    private void displayChangeManagerRecAg(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new recruting agency of the manager:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long newRecrutingAgency = Long.parseLong(input.nextLine());
        managerController.updateManagerRecAg(Id, newRecrutingAgency);
        System.out.println("Manager update successful.");
    }

//</editor-fold>

//<editor-fold desc="Recruting agency display block">

    private void displayAllRecrutingAgencyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All recruting agencies:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<RecrutingAgency> recrutingAgencies = recrutingAgencyController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(recrutingAgencies));
    }

    private void displayRecrutingAgencyByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter recruting agency Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        RecrutingAgency recrutingAgency = recrutingAgencyController.getById(Id);

        if (recrutingAgency != null)
            System.out.println(JsonConverter.getConvertedToJson(recrutingAgency));
        else
            System.out.println("No recruting agency with such Id.");
    }

    private void displayDeleteRecrutingAgencyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter id of a recruting agency to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this recruting agency? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = recrutingAgencyController.deleteRecAg(Id);
                    if (result)
                        System.out.println("Recruting agency successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid recruting agency Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }

    }

    private void displayAddRecrutingAgencyPage() {
        String name;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter recruting agency name:");
        name = input.nextLine();

        recrutingAgencyController.addRecAg(name);
        System.out.println("Recruting agency added successfully.");
    }

//</editor-fold>

//<editor-fold desc="Vacancy display block">

    private void displayAllVacancyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All vacancies:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Vacancy> vacancies = vacancyController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(vacancies));
    }

    private void displayVacancyByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter vacancy Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        Vacancy vacancy = vacancyController.getById(Id);

        if (vacancy != null)
            System.out.println(JsonConverter.getConvertedToJson(vacancy));
        else
            System.out.println("No vacancy with such Id.");
    }

    private void displayVacancyByPositionPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter propose position: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String propPosition = input.nextLine();
        List<Vacancy> vacancies = vacancyController.getByPropPositionVac(propPosition);
        if (vacancies != null)
            System.out.println(JsonConverter.getConvertedToJson(vacancies));
        else
            System.out.println("No vacancies with such propose position.");
    }

    private void displayDeleteVacancyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a vacancy to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this vacancy? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = vacancyController.deleteVacancy(Id);
                    if (result)
                        System.out.println("Vacancy successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid vacancy id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayAddVacancyPage() {
        Long employerCompany;
        String proposedPosition;
        Integer proposedSalary;
        Integer experience;
        Integer age;
        String gender;
        String workShedule;
        String spesialty;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter employer company Id:");
        employerCompany = Long.parseLong(input.nextLine());
        System.out.println("2. Enter proposed position:");
        proposedPosition = input.nextLine();
        System.out.println("3. Enter proposed salary:");
        proposedSalary = Integer.parseInt(input.nextLine());
        System.out.println("4. Enter experience:");
        experience = Integer.parseInt(input.nextLine());
        System.out.println("5. Enter age:");
        age = Integer.parseInt(input.nextLine());
        System.out.println("6. Enter gender:");
        gender = input.nextLine();
        System.out.println("7. Enter work shedule:");
        workShedule = input.nextLine();
        System.out.println("8. Enter spesialty:");
        spesialty = input.nextLine();

        vacancyController.addVacancy(employerCompany, proposedPosition, proposedSalary, experience,
                age, gender, workShedule, spesialty);
        System.out.println("Vacancy added successfully.");
    }

    private void displayEditVacancyPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a vacancy to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (vacancyController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No vacancy with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change vacancy proposed salary");
            System.out.println("   2. Change vacancy proposed position");
            System.out.println("   3. Change vacancy employer company Id");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeVacancyPropSalary(Id);
                    break;
                case(2):
                    displayChangeVacancyPropPosition(Id);
                    break;
                case(3):
                    displayChangeVacancyEmpComp(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeVacancyPropSalary(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new propose salary:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Integer newProposeSalary = Integer.parseInt(input.nextLine());
        vacancyController.updateVaclPropSalary(Id, newProposeSalary);
        System.out.println("Vacancy update successful.");
    }

    private void displayChangeVacancyPropPosition(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new propose position:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        String newProposePosition = input.nextLine();
        vacancyController.updateVaclPropPosition(Id, newProposePosition);
        System.out.println("Vacancy update successful.");
    }

    private void displayChangeVacancyEmpComp(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter new employer company Id:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long newEmployerCompany = Long.parseLong(input.nextLine());
        vacancyController.updateVacancyEmpComp(Id, newEmployerCompany);
        System.out.println("Vacancy update successful.");
    }
//</editor-fold>

//<editor-fold desc="Work contract display block">

    private void displayAllWorkContractPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("All work contracts:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<WorkContract> workContracts = workContractController.getAll();
        System.out.println(JsonConverter.getConvertedToJson(workContracts));
    }

    private void displayWorkContractByIdPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter work contract Id: ");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());
        WorkContract workContract = workContractController.getById(Id);

        if (workContract != null)
            System.out.println(JsonConverter.getConvertedToJson(workContract));
        else
            System.out.println("No work contract with such Id.");
    }

    private void displayAddWorkContractPage() {
        Long applicant;
        Long manager;
        Long vacancy;
        Date contractDuration;
        Date beginningOfWork;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter input data.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Enter applicant Id:");
        applicant = Long.parseLong(input.nextLine());
        System.out.println("2. Enter manager Id:");
        manager = Long.parseLong(input.nextLine());
        System.out.println("3. Enter vacancy Id:");
        vacancy = Long.parseLong(input.nextLine());
        System.out.println("4. Enter contract duration:");
        contractDuration = Date.valueOf(input.nextLine());
        System.out.println("5. Enter beginning of work:");
        beginningOfWork = Date.valueOf(input.nextLine());


        workContractController.addWorkContract(applicant, manager, vacancy, contractDuration, beginningOfWork);
        System.out.println("Work contract added successfully.");
    }

    private void displayDeleteWorkContractPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a work contract to delete:");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Long Id = Long.parseLong(input.nextLine());

        boolean show = true;
        boolean result;

        while (show) {
            System.out.println("Are you sure you want to delete this work contract? (y/n)");

            String option = input.nextLine();
            switch (option) {
                case ("y"):
                    result = workContractController.deleteWorkContract(Id);
                    if (result)
                        System.out.println("Work contract successfully deleted.");
                    else
                        System.out.println("Error: Unsuccessful. Invalid work contract Id.");
                    show = false;
                    break;
                case ("n"):
                    show = false;
                    break;
            }
        }
    }

    private void displayEditWorkContractPage() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Id of a work contract to edit.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Long Id = Long.parseLong(input.nextLine());

        if (workContractController.getById(Id) == null){
            System.out.println("Error: Unsuccessful. No work contract with such Id.");
            return;
        }

        boolean show = true;
        while(show){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Choose what you want to edit: ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("   1. Change contract duration");
            System.out.println("   0. Back to menu");

            int option;
            try{
                option = Integer.parseInt(input.nextLine());
            }
            catch(Exception e){
                option = -1;
            }
            switch (option){
                case(1):
                    displayChangeContractDuration(Id);
                    break;
                case(0):
                    show = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void displayChangeContractDuration(Long Id) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter each date parametr (year, month and day) on a new line :");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        Integer newYear = Integer.parseInt(input.nextLine());
        Integer newMonth = Integer.parseInt(input.nextLine());
        Integer newDay = Integer.parseInt(input.nextLine());
        workContractController.updateContractDuration(Id, newYear, newMonth, newDay);
        System.out.println("Vacancy update successful.");
    }
//</editor-fold>
}
