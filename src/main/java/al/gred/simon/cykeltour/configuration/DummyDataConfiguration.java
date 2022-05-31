package al.gred.simon.cykeltour.configuration;


import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Stage;
import al.gred.simon.cykeltour.entity.Team;
import al.gred.simon.cykeltour.repository.RiderRepository;
import al.gred.simon.cykeltour.repository.StageRepository;
import al.gred.simon.cykeltour.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Configuration
@Profile({"!production & !test"})
@RequiredArgsConstructor
public class DummyDataConfiguration implements ApplicationRunner {
    private final TeamRepository teamRepository;
    private final RiderRepository riderRepository;
    private final StageRepository stageRepository;

    private Team createQuickStepAlphaVinylTeam() {
        var team = Team.builder().name("Quick-Step Alpha Vinyl Team").build();

        var riders = Set.of(
                Rider.builder().team(team).name("Michael Mørkøv").birth(LocalDate.parse("1985-04-30")).country("DK").flag("🇩🇰").build(),
                Rider.builder().team(team).name("Yves Lampaert").birth(LocalDate.parse("1991-04-10")).country("BE").flag("🇧🇪").build(),
                Rider.builder().team(team).name("Tim Declercq").birth(LocalDate.parse("1989-03-21")).country("BE").flag("🇧🇪").build(),
                Rider.builder().team(team).name("Julian Alaphilippe").birth(LocalDate.parse("1992-06-11")).country("FR").flag("🇫🇷").build(),
                Rider.builder().team(team).name("Fabio Jakobsen").birth(LocalDate.parse("1996-08-31")).country("NE").flag("🇳🇱").build(),
                Rider.builder().team(team).name("Florian Sénéchal").birth(LocalDate.parse("1993-07-10")).country("FR").flag("🇫🇷").build(),
                Rider.builder().team(team).name("Kasper Asgreen").birth(LocalDate.parse("1995-02-08")).country("DK").flag("🇩🇰").build(),
                Rider.builder().team(team).name("Rémi Cavagna").birth(LocalDate.parse("1995-08-10")).country("FR").flag("🇫🇷").build(),
                Rider.builder().team(team).name("Mikkel Frølich Honoré").birth(LocalDate.parse("1997-01-21")).country("DK").flag("🇩🇰").build()
        );

        team.setRiders(riders);

        return team;
    }

    private List<Stage> createFirstThreeStages() {
        return List.of(
                Stage.builder().name("1. etape: København - København (13km)").description("https://letourcph.dk/oplev-tre-etaper/1-etape").build(),
                Stage.builder().name("2. etape: Roskilde - Nyborg (202km)").description("https://letourcph.dk/oplev-tre-etaper/2-etape").build(),
                Stage.builder().name("3. etape: Vejle - Sønderborg (182km)").description("https://letourcph.dk/oplev-tre-etaper/3-etape").build()
        );
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Configuration was run!!!!!!!!!!");

        teamRepository.deleteAll();
        teamRepository.save(createQuickStepAlphaVinylTeam());

        stageRepository.deleteAll();
        stageRepository.saveAll(createFirstThreeStages());
    }
}


/*
Quick-Step Alpha Vinyl Team

 MØRKØV Michael
 LAMPAERT Yves
 DECLERCQ Tim
 ALAPHILIPPE Julian
 JAKOBSEN Fabio
 SÉNÉCHAL Florian
 ASGREEN Kasper
 CAVAGNA Rémi
 HONORÉ Mikkel Frølich
Jumbo-Visma

 KUSS Sepp
 BENOOT Tiesj
 VINGEGAARD Jonas
 DENNIS Rohan
 VAN AERT Wout
 ROGLIČ Primož
 KRUIJSWIJK Steven
Astana Qazaqstan Team

 BATTISTELLA Samuele
 LUTSENKO Alexey
 LÓPEZ Miguel Ángel
 MOSCON Gianni
AG2R Citroën Team

 VAN AVERMAET Greg
 JUNGELS Bob
 BOUCHARD Geoffrey
 O'CONNOR Ben
 COSNEFROY Benoît
 PARET-PEINTRE Aurélien
 NAESEN Oliver
Bahrain - Victorious

 TEUNS Dylan
 MOHORIČ Matej
 CARUSO Damiano
 MÄDER Gino
 LANDA Mikel
 HAIG Jack
UAE Team Emirates

 MCNULTY Brandon
 MAJKA Rafał
 SOLER Marc
 HIRSCHI Marc
 POGAČAR Tadej
 BENNETT George
Team BikeExchange - Jayco

 YATES Simon
 MATTHEWS Michael
 DURBRIDGE Luke
 MEZGEC Luka
 GROENEWEGEN Dylan
Movistar Team

 OLIVEIRA Nelson
 VERONA Carlos
 ERVITI Imanol
 IZAGIRRE Gorka
 JORGENSON Matteo
 MAS Enric
Team Arkéa Samsic

 PICHON Laurent
 QUINTANA Nairo
 BARGUIL Warren
 BOUHANNI Nacer
Intermarché - Wanty - Gobert Matériaux

 ZIMMERMANN Georg
 GOOSSENS Kobe
 MEINTJES Louis
 VAN DER HOORN Taco
 PETIT Adrien
 HERMANS Quinten
 PASQUALON Andrea
 KRISTOFF Alexander
Groupama - FDJ

 STORER Michael
 GENIETS Kevin
 LADAGNOUS Matthieu
 ARMIRAIL Bruno
 LE GAC Olivier
 GAUDU David
 PINOT Thibaut
 MADOUAS Valentin
 KÜNG Stefan
TotalEnergies

 FERRON Valentin
 DOUBEY Fabien
 VUILLERMOZ Alexis
 JOUSSEAUME Alan
 SAGAN Peter
 LATOUR Pierre
Team DSM

 BOL Cees
 DEGENKOLB John
 EEKHOFF Nils
 BARDET Romain
 KRAGH ANDERSEN Søren
 ARNDT Nikias
Alpecin-Deceuninck

 VERMEERSCH Gianni
 MEURISSE Xandro
 MERLIER Tim
 VAN DER POEL Mathieu
 PHILIPSEN Jasper
Trek - Segafredo

 SIMMONS Quinn
 STUYVEN Jasper
 TOLHOEK Antwan
 MOLLEMA Bauke
 PEDERSEN Mads
 CICCONE Giulio
BORA - hansgrohe

 SCHACHMANN Maximilian
 GROßSCHARTNER Felix
 VLASOV Aleksandr
 POLITT Nils
 BENNETT Sam
 KONRAD Patrick
 VAN POPPEL Danny
Cofidis

 PÉRICHON Pierre-Luc
 MARTIN Guillaume
 COQUARD Bryan
 IZAGIRRE Ion
 THOMAS Benjamin
 GESCHKE Simon
INEOS Grenadiers

 MARTÍNEZ Daniel Felipe
 SIVAKOV Pavel
 YATES Adam
 PIDCOCK Thomas
 GANNA Filippo
 VAN BAARLE Dylan
 KWIATKOWSKI Michał
 CASTROVIEJO Jonathan
 THOMAS Geraint
Israel - Premier Tech

 WÜRTZ SCHMIDT Mads
 GOLDSTEIN Omer
 WOODS Michael
 FROOME Chris
 FUGLSANG Jakob
 HAGEN Carl Fredrik
Lotto Soudal

 VAN MOER Brent
 WELLENS Tim
 GILBERT Philippe
 EWAN Caleb
EF Education-EasyPost

 VALGREN Michael
 URÁN Rigoberto
 BETTIOL Alberto
 GUERREIRO Ruben
 PADUN Mark
 RUTSCH Jonas
 CORT Magnus
B&B Hotels - KTM

 GOUGEARD Alexis
 SCHÖNBERGER Sebastian
 ROLLAND Pierre
 BONNAMOUR Franck
 LIETAER Eliot
 */
