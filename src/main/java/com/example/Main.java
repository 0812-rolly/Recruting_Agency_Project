package com.example;

import com.example.DAL.Model.*;
import com.example.util.HibernateUtil;
import com.example.util.StringHandler;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        fillDatabase(sessionFactory.openSession());
        //start();

        HibernateUtil.shutdown();
    }

    private static void fillDatabase(Session session) {
        final Transaction transaction = session.beginTransaction();

        Admin admin = new Admin();
        admin.setEmail("belozub.yanochka@mail.ru");
        admin.setPassword(StringHandler.encryptString("qwerty1234"));

        RecrutingAgency recag1 = new RecrutingAgency();
        recag1.setName("Staffline");
        RecrutingAgency recag2 = new RecrutingAgency();
        recag2.setName("Anchor");

        Manager man1 = new Manager();
        man1.setRecrutingAgency(recag1);
        man1.setSurname("Kiseleva");
        man1.setName("Stephanie");
        man1.setPatronymic("Alexandrovna");
        man1.setPhoneNumber("+79086643473");

        Manager man2 = new Manager();
        man2.setRecrutingAgency(recag2);
        man2.setSurname("Meshkov");
        man2.setName("Leo");
        man2.setPatronymic("Mikhailovich");
        man2.setPhoneNumber("+79067458778");

        Company comp1 = new Company();
        comp1.setName("NetCracker");
        comp1.setCity("Saratov");
        comp1.setAddres("st. Slonova, 1");
        comp1.setPhoneNumber("+78452399669");

        Company comp2 = new Company();
        comp2.setName("PJSC Rosseti Volga");
        comp2.setCity("Samara");
        comp2.setAddres("Blizhnaya st., 4");
        comp2.setPhoneNumber("+78007751642");

        Company comp3 = new Company();
        comp3.setName("Sberbank of Russia");
        comp3.setCity("St. Petersburg");
        comp3.setAddres("st. 2nd Krasnoarmeiskaya, 2/27");
        comp3.setPhoneNumber("+7800555555");

        EmployerCompany empcomp1 = new EmployerCompany();
        empcomp1.setName("Carcade Leasing");
        empcomp1.setCity("Saratov");
        empcomp1.setAddres("Bolshaya Sadovaya st., 239");
        empcomp1.setPhoneNumber("+78005515412");

        EmployerCompany empcomp2 = new EmployerCompany();
        empcomp2.setName("Rosseti Volga");
        empcomp2.setCity("Saratov");
        empcomp2.setAddres("st. Pervomayskaya, 42/44");
        empcomp2.setPhoneNumber("+78452302659");

        EmployerCompany empcomp3 = new EmployerCompany();
        empcomp3.setName("Mercury Development");
        empcomp3.setCity("Saratov");
        empcomp3.setAddres("Bolshaya Kazachya st., 49/65");
        empcomp3.setPhoneNumber("+78462794992");

        EducationInstitution edinst1 = new EducationInstitution();
        edinst1.setName("SSU named by N.G. Chernyshevsky");
        edinst1.setCity("Saratov");
        edinst1.setAddres("Astrakhanskaya St., 83");
        edinst1.setPhoneNumber("+78452261696");

        EducationInstitution edinst2 = new EducationInstitution();
        edinst2.setName("Saint Petersburg State University of Economics");
        edinst2.setCity("St. Petersburg");
        edinst2.setAddres("emb. Griboyedov Canal, 30-32");
        edinst2.setPhoneNumber("+78124589758");

        EducationInstitution edinst3 = new EducationInstitution();
        edinst3.setName("Moscow Power Engineering Institute");
        edinst3.setCity("Moscow");
        edinst3.setAddres("Zhukovsky, Molodozhnaya street, 27");
        edinst3.setPhoneNumber("+79162228335");


        Applicant appl1 = new Applicant();
        appl1.setSurname("Kostenko");
        appl1.setName("Dmitry");
        appl1.setPatronymic("Sergeyevich");
        appl1.setGender("m");
        appl1.setAge(29);
        appl1.setCity("Moscow");
        appl1.setAddres("Novinsky Boulevard, 18k1");
        appl1.setPhoneNumber("+79025438776");
        appl1.setPasportNumber("6312542378");
        appl1.setInn("906182079907");
        appl1.setSnils("58093972441");
        appl1.setRequiredPosition("Engineer");
        appl1.setRequiredSalary(50000);
        appl1.setWorkShedule("Full");
        appl1.setApplicationDate(Date.valueOf("2020-12-23"));
        appl1.setApplicationStatus("open");

        Applicant appl2 = new Applicant();
        appl2.setSurname("Abramova");
        appl2.setName("Olga");
        appl2.setPatronymic("Igorevna");
        appl2.setGender("f");
        appl2.setAge(25);
        appl2.setCity("Saratov");
        appl2.setAddres("1st Green passage, 17");
        appl2.setPhoneNumber("+79874675567");
        appl2.setPasportNumber("6301347904");
        appl2.setInn("897376959470");
        appl2.setSnils("65952023815");
        appl2.setRequiredPosition("Accountant");
        appl2.setRequiredSalary(17000);
        appl2.setWorkShedule("Full");
        appl2.setApplicationDate(Date.valueOf("2021-01-30"));
        appl2.setApplicationStatus("open");

        Applicant appl3 = new Applicant();
        appl3.setSurname("Pozlovskiy");
        appl3.setName("Dmitry");
        appl3.setPatronymic("Anatolyevich");
        appl3.setGender("m");
        appl3.setAge(32);
        appl3.setCity("Saratov");
        appl3.setAddres("Kutyakova street, 22");
        appl3.setPhoneNumber("+79064537268");
        appl3.setPasportNumber("6246876547");
        appl3.setInn("505478734276");
        appl3.setSnils("34927188920");
        appl3.setRequiredPosition("Programmer");
        appl3.setRequiredSalary(30000);
        appl3.setWorkShedule("Full");
        appl3.setApplicationDate(Date.valueOf("2021-02-23"));
        appl3.setApplicationStatus("open");

        LaborHistory labh1 = new LaborHistory();
        labh1.setApplicant(appl1);
        labh1.setCompany(comp2);
        labh1.setPosition("Engineer-technologist");
        labh1.setExperience(5);

        LaborHistory labh2 = new LaborHistory();
        labh2.setApplicant(appl2);
        labh2.setCompany(comp3);
        labh2.setPosition("Accountant");
        labh2.setExperience(2);

        LaborHistory labh3 = new LaborHistory();
        labh3.setApplicant(appl3);
        labh3.setCompany(comp1);
        labh3.setPosition("Programmer");
        labh3.setExperience(3);

        Education ed1 = new Education();
        ed1.setEducationInstitution(edinst3);
        ed1.setApplicant(appl1);
        ed1.setFaculty("IEPI");
        ed1.setSpecialty("Process Engineer");
        ed1.setTypeOfDocument("Bachelors degree");
        ed1.setStartDate(2010);
        ed1.setEndDate(2014);

        Education ed2 = new Education();
        ed2.setEducationInstitution(edinst2);
        ed2.setApplicant(appl2);
        ed2.setFaculty("FBL");
        ed2.setSpecialty("Accountant");
        ed2.setTypeOfDocument("Bachelors degree");
        ed2.setStartDate(2012);
        ed2.setEndDate(2016);

        Education ed3 = new Education();
        ed3.setEducationInstitution(edinst1);
        ed3.setApplicant(appl3);
        ed3.setFaculty("CSIT");
        ed3.setSpecialty("Programmer-developer");
        ed3.setTypeOfDocument("Bachelors degree");
        ed3.setStartDate(2013);
        ed3.setEndDate(2017);


        Vacancy v1 = new Vacancy();
        v1.setEmployerCompany(empcomp3);
        v1.setProposedPosition("Programmer");
        v1.setProposedSalary(35000);
        v1.setExperience(3);
        v1.setAge(23);
        v1.setGender("m");
        v1.setWorkShedule("Full");
        v1.setSpesialty("Programmer-developer");

        Vacancy v2 = new Vacancy();
        v2.setEmployerCompany(empcomp2);
        v2.setProposedPosition("Accountant");
        v2.setProposedSalary(10000);
        v2.setExperience(2);
        v2.setAge(21);
        v2.setGender("f");
        v2.setWorkShedule("Full");
        v2.setSpesialty("Accountant");

        Vacancy v3 = new Vacancy();
        v3.setEmployerCompany(empcomp1);
        v3.setProposedPosition("Engineer");
        v3.setProposedSalary(50000);
        v3.setExperience(5);
        v3.setAge(27);
        v3.setGender("m");
        v3.setWorkShedule("Full");
        v3.setSpesialty("Engineer-technologist");

        WorkContract wc1 = new WorkContract();
        wc1.setApplicant(appl1);
        wc1.setManager(man2);
        wc1.setVacancy(v1);
        wc1.setContractDuration(Date.valueOf("2024-02-28"));
        wc1.setBeginningOfWork(Date.valueOf("2021-02-28"));

        session.save(admin);
        session.save(recag1);
        session.save(recag2);
        session.save(man1);
        session.save(man2);
        session.save(comp1);
        session.save(comp2);
        session.save(comp3);
        session.save(empcomp1);
        session.save(empcomp2);
        session.save(empcomp3);
        session.save(edinst1);
        session.save(edinst2);
        session.save(edinst3);
        session.save(labh1);
        session.save(labh2);
        session.save(labh3);
        session.save(ed1);
        session.save(ed2);
        session.save(ed3);
        session.save(wc1);
        session.save(v1);
        session.save(v2);
        session.save(v3);
        session.save(appl1);
        session.save(appl2);
        session.save(appl3);

        transaction.commit();
        session.close();
    }

//    private static void start() {
//        MainNavigator view = new MainNavigator();
//        while (UserUtil.getCurrentUser() == null) {
//            view.showLoginPage();
//        }
//    }

    }


