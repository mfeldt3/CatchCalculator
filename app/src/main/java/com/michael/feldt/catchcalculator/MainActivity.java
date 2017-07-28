package com.michael.feldt.catchcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnFocusChangeListener {
    private static final String[] pokemon= {"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard", "Squirtle", "Warturtle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle",
    "Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Sandshrew","Sandslash","Nidoran","Nidorina","NidoQueen","Nidoran","Nidorino","NidoKing",
            "Clefairy","Clefable","Vulpix","Ninetails","Jigglypuff","Wigglytuff","Zubat","Golbat","Oddish","Gloom","Vileplume","Paras","Parasect","Venonat","Venomoth","Diglett","Dugtrio","Meowth","Persian",
            "Psyduck","Golduck","Mankey","Primeape","Growlithe","Arcanine","Poliwag","Poliwhirl","Poliwrath","Abra","Kadabra","Alakazam","Machop","Machoke","Machamp","Bellsprout","Weepinbell","Victreebel","Tentacool",
            "Tentacruel","Geodude","Graveler","Golem","Ponyta","Rapidash","Slowpoke","Slowbro","Magnemite","Magneton","Farfetch'd","Doduo","Dodrio","Seel","Dewgong","Grimer","Muk","Shellder","Cloyster",
            "Gastly","Haunter","Gengar","Onix","Drowzee","Hypno","Krabby","Kingler","Voltorb","Electrode","Exeggcute","Exeggutor","Cubone","Marowak","Hitmonlee","Hitmonchan","Lickitung","Koffing","Weezing",
            "Rhyhorn","Rhydon","Chansey","Tangela","Kangaskhan","Horsea","Seadra","Goldeen","Seaking","Staryu","Starmie","Mr.Mime","Scyther","Jynx","Electrabuzz","Magmar","Pinsir","Tauros","Magikarp","Gyarados",
            "Lapras","Ditto","Eevee","Vaporeon","Jolteon","Flareon","Porygon","Omanyte","Omastar","Kabuto","Kabutops","Aerodactyl","Snorlax","Articuno","Zapdos","Moltres","Dratini","Dragonair","Dragonite","Mewtwo","Mew",
            "Chikorita","Bayleef","Meganium","Cyndaquil","Quilava","Typhlosion","Totodile","Croconaw","Feraligatr","Sentret","Furret","Hoothoot","Noctowl","Ledyba","Ledian","Spinarak","Ariados","Crobat","Chinchou","Lanturn",
            "Pichu","Cleffa","Igglybuff","Togepi","Togetic","Natu","Xatu","Mareep","Flaaffy","Ampharos","Bellossom","Marill","Azumarill","Sudowoodo","Politoed","Hoppip","Skiploom","Jumpluff","Aipom","Sunkern","Sunflora","Yanma",
            "Wooper","Quagsire","Espeon","Umbreon","Murkrow","Slowking","Misdreavus","Unown","Wobbuffet","Girafarig","Pineco","Forretress","Dunsparce","Gligar","Steelix","Snubbull","Granbull","Qwilfish","Scizor","Shuckle","Heracross",
            "Sneasel","Teddiursa","Ursaring","Slugma","Magcargo","Swinub","Piloswine","Corsola","Remoraid","Octillery","Delibird","Mantine","Skarmory","Houndour","Houndoom","Kingdra","Phanpy","Donphan","Porygon2", "Stantler", "Smeargle",
            "Tyrogue","Hitmontop","Smoochum","Elekid","Magby","Miltank","Blissey","Raikou","Entei","Suicune","Larvitar","Pupitar","Tyranitar","Lugia","Ho-oh","Celebi"
    };
    private static final String[] tot12={"Caterpie","Weedle","Pidgey"};
    private static final String[] tot25={"Bulbasaur","Charmander","Squirtle","Nidoran","Oddish","Poliwag","Abra","Bellsprout","Machop","Geodude","Gastly","Dratini","Chikorita","Cyndaquil","Totodile", "Mareep","Hoppip","Larvitar","Rattata","Zubat",
    "Horsea","Eevee","Sentret","Ledyba","Pichu","Cleffa","Igglybuff","Marill","Tyrogue","Smoochum","Elekid","Magby"};
    private static final String[] tot50={"Metapod","Kakuna","Pidgeotto","Spearow","Ekans","Pikachu","Sandshrew","Clefairy","Vulpix","Jigglypuff","Paras","Venonat","Diglett","Meowth","Psyduck","Mankey","Growlithe","Tentacool","Ponyta","Slowpoke","Magnemite",
    "Doduo","Seel","Grimer","Shellder","Onix","Drowzee","Krabby","Voltorb","Exeggcute","Cubone","Koffing","Rhyhorn","Chansey","Goldeen","Staryu","Scyther","Omanyte","Kabuto","Hoothoot","Spinarak","Chinchou","Togepi","Natu","Sunkern","Wooper","Pineco","Snubbull","Teddiursa","Slugma","Swinub","Remoraid","Houndour","Phanpy"};
    private static final String[] tot62={"Caterpie","Weedle","Pidgey"};
    private static final String[] tot75={"Pichu","Cleffa","Igglybuff"};
    private static final String[] tot100={"Ivysaur","Charmeleon","Warturtle","Nidorina","Nidorino","Golbat","Gloom","Polywhirl","Seadra","Kadabra","Machoke","Weepinbell","Graveler","Haunter","Dragonair","Bayleef","Quilava","Croconaw","Flaaffy","Skiploom","Pupitar"};
    private static final String[] tot125={"Bulbasaur","Charmander","Squirtle","Nidoran","Oddish","Poliwag","Abra","Bellsprout","Machop","Geodude","Gastly","Dratini","Chikorita","Cyndaquil","Totodile", "Mareep","Hoppip","Larvitar"};
    private static final String[] tot400={"Magikarp"};
    private static final String[] nonEvo={"Farfetch'd","Kangaskhan","Pinsir","Tauros","Lapras","Ditto","Aerodactyl","Articuno","Zapdos","Moltres","Mewtwo","Mew","Unown","Girafarig","Dunsparce","Qwilfish","Shuckle","Heracross","Corsola","Delibird","Skarmory",
    "Stantler","Smeargle","Miltank","Raikou","Entei","Suicune","Lugia","Ho-Oh","Celebi","Venusaur","Charizard","Blastoise","Butterfree","Beedrill","Pidgeot","Raticate","Fearow","Arbok","Raichu","Sandslash","Nidoqueen","NidoKing","Clefable","Ninetails","Wigglytuff","Vileplume",
    "Parasect","Venomoth","Dugtrio","Persian","Golduck","Primeape","Arcanine","Poliwrath","Alakazam","Machamp","Victreebel","Tentacruel","Golem","Rapidash","Slowbro","Magneton","Dodrio","Dewgong","Muk","Cloyster","Gengar","Hypno","Kingler","Electrode","Exeggutor","Marowak","Hitmonlee","Hitmonchan",
    "Weezing","Rhydon","Tangela","Seaking","Starmie","Mr.Mime","Lickitung","Jynx","Electrabuzz","Magmar","Gyarados","Vaporeon","Jolteon","Flareon","Omastar","Kabutops","Snorlax","Dragonite","Meganium","Typhlosion","Feraligatr","Furret","Noctowl","Ledian","Ariados","Crobat","Lanturn","Xatu","Ampharos","Bellossom","Azumarill","Sudowoodo",
    "Politoed","Togetic","Jumpluff","Aipom","Sunflora","Yanma","Quagsire","Sneasel","Murkrow","Piloswine","Espeon","Umbreon","Porygon2","Slowking","Misdreavus","Wobbuffet","Forretress","Steelix","Granbull","Gligar","Scizor","Ursaring","Magcargo","Octillery","Mantine","Houndoom","Kingdra","Donphan","Hitmontop","Blissey","Raikou","Suicune","Tyranitar","Ho-oh","Celebi"};

    TextView label;
    TextView evolution;
    TextView beginText;
    GridView grid;
    EditText candyNum;
    double candyTotal=0;
    double candyDivider=3;
    CheckBox transferCheck;
    CheckBox pinapCheck;
    double remainder;
    double remainderFull;
    int evolveTimes;
    int fullEvoRemain;
    int remain;
    boolean firstEvolution;
    boolean secondEvolution;
    double doubleRemain;
    String poke;
    String pokenext;
    String pokenextnext;
    final ArrayList<String> list12=new ArrayList<String>();
    final ArrayList<String> list25=new ArrayList<String>();
    final ArrayList<String> list50=new ArrayList<String>();
    final ArrayList<String> list62=new ArrayList<String>();
    final ArrayList<String> list75=new ArrayList<String>();
    final ArrayList<String> list100=new ArrayList<String>();
    final ArrayList<String> list125=new ArrayList<String>();
    final ArrayList<String> list400=new ArrayList<String>();
    final ArrayList<String> listUnEvo=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beginText=(TextView) findViewById(R.id.startText);
        label= (TextView) findViewById(R.id.textView);
        evolution=(TextView) findViewById(R.id.Evolution3);
        grid=(GridView) findViewById(R.id.gridView);
        candyNum=(EditText) findViewById(R.id.candyNum);
        transferCheck=(CheckBox) findViewById(R.id.checkBox);
        pinapCheck=(CheckBox) findViewById(R.id.pinapBox);
        candyNum.setText("0");
        candyNum.setOnFocusChangeListener(this);
        if (transferCheck!=null)
        {
            transferCheck.setOnCheckedChangeListener(this);
        }
        if (pinapCheck!=null)
        {
            pinapCheck.setOnCheckedChangeListener(this);
        }
        for (int i=0; i<nonEvo.length; ++i){
            listUnEvo.add(nonEvo[i]);
        }
        for (int i=0; i<tot12.length; ++i)
        {
            list12.add(tot12[i]);
        }
        for (int i=0; i<tot25.length; ++i)
        {
            list25.add(tot25[i]);
        }
        for (int i=0; i<tot50.length; ++i)
        {
            list50.add(tot50[i]);
        }
        for (int i=0; i<tot62.length; ++i)
        {
            list62.add(tot62[i]);
        }
        for (int i=0; i<tot75.length; ++i)
        {
            list75.add(tot75[i]);
        }
        for (int i=0; i<tot100.length; ++i)
        {
            list100.add(tot100[i]);
        }
        for (int i=0; i<tot125.length; ++i)
        {
            list125.add(tot125[i]);
        }
        for (int i=0; i<tot400.length; ++i)
        {
            list400.add(tot400[i]);
        }

        grid.setAdapter(new ImageAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                label.setVisibility(View.INVISIBLE);
                evolution.setVisibility(View.INVISIBLE);
                beginText.setVisibility(View.VISIBLE);
                view.setSelected(true);
                poke=pokemon[position];
                pokenext=pokemon[position+1];
                pokenextnext=pokemon[position+2];

            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() ==R.id.checkBox && isChecked)
        {
            label.setVisibility(View.INVISIBLE);
            evolution.setVisibility(View.INVISIBLE);
            beginText.setVisibility(View.VISIBLE);
            candyDivider=candyDivider+1;
        }
        if (buttonView.getId() ==R.id.checkBox && !isChecked)
        {
            label.setVisibility(View.INVISIBLE);
            evolution.setVisibility(View.INVISIBLE);
            beginText.setVisibility(View.VISIBLE);
            candyDivider=candyDivider-1;
        }
        if (buttonView.getId() ==R.id.pinapBox && isChecked)
        {
            label.setVisibility(View.INVISIBLE);
            evolution.setVisibility(View.INVISIBLE);
            beginText.setVisibility(View.VISIBLE);
            candyDivider=candyDivider+3;
        }
        if (buttonView.getId() ==R.id.pinapBox && !isChecked)
        {
            label.setVisibility(View.INVISIBLE);
            evolution.setVisibility(View.INVISIBLE);
            beginText.setVisibility(View.VISIBLE);
            candyDivider=candyDivider-3;
        }



    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        View view=this.getCurrentFocus();
        if (view!=null){
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        public ImageAdapter (Context c){
            mContext=c;
        }
        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView==null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setPadding(8, 8, 8, 8);
            }else{
                  imageView=(ImageView) convertView;
                }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        private Integer[] mThumbIds= {
          R.drawable.bulbasaur,R.drawable.ivysaur,R.drawable.venusaur,R.drawable.charmander,R.drawable.charmeleon,R.drawable.charizard,R.drawable.squirtle,R.drawable.wartortle,R.drawable.blastoise,
                R.drawable.caterpie,R.drawable.metapod,R.drawable.butterfree,R.drawable.weedle,R.drawable.kakuna,R.drawable.beedrill,R.drawable.pidgey,R.drawable.pidgeotto,R.drawable.pidgeot,R.drawable.rattata,
                R.drawable.raticate,R.drawable.spearow,R.drawable.fearow,R.drawable.ekans,R.drawable.arbok,R.drawable.pikachu,R.drawable.raichu,R.drawable.sandshrew,R.drawable.sandslash,R.drawable.nidoranf,
                R.drawable.nidorina,R.drawable.nidoqueen,R.drawable.nidoranm,R.drawable.nidorino,R.drawable.nidoking,R.drawable.clefairy,R.drawable.clefable,R.drawable.vulpix,R.drawable.ninetales,R.drawable.jigglypuff,
                R.drawable.wigglytuff,R.drawable.zubat,R.drawable.golbat,R.drawable.oddish,R.drawable.gloom,R.drawable.vileplume,R.drawable.paras,R.drawable.parasect,R.drawable.venonat,R.drawable.venomoth,R.drawable.diglett,
                R.drawable.dugtrio,R.drawable.meowth,R.drawable.persian,R.drawable.psyduck,R.drawable.golduck,R.drawable.mankey,R.drawable.primeape,R.drawable.growlithe,R.drawable.arcanine,R.drawable.poliwag,R.drawable.poliwhirl,
                R.drawable.poliwrath,R.drawable.abra,R.drawable.kadabra,R.drawable.alakazam,R.drawable.machop,R.drawable.machoke,R.drawable.machamp,R.drawable.bellsprout,R.drawable.weepinbell,R.drawable.victreebel,R.drawable.tentacool,
                R.drawable.tentacruel,R.drawable.geodude,R.drawable.graveler,R.drawable.golem,R.drawable.ponyta,R.drawable.rapidash,R.drawable.slowpoke,R.drawable.slowbro,R.drawable.magnemite,R.drawable.magneton,
                R.drawable.farfetchd,R.drawable.doduo,R.drawable.dodrio,R.drawable.seel,R.drawable.dewgong,R.drawable.grimer,R.drawable.muk,R.drawable.shellder,R.drawable.cloyster,R.drawable.gastly,R.drawable.haunter,R.drawable.gengar,
                R.drawable.onix,R.drawable.drowzee,R.drawable.hypno,R.drawable.krabby,R.drawable.kingler,R.drawable.voltorb,R.drawable.electrode,R.drawable.exeggcute,R.drawable.exeggutor,R.drawable.cubone,R.drawable.marowak,R.drawable.hitmonlee,
                R.drawable.hitmonchan,R.drawable.lickitung,R.drawable.koffing,R.drawable.weezing,R.drawable.rhyhorn,R.drawable.rhydon,R.drawable.chansey,R.drawable.tangela,R.drawable.kangaskhan,R.drawable.horsea,R.drawable.seadra,
                R.drawable.goldeen,R.drawable.seaking,R.drawable.staryu,R.drawable.starmie,R.drawable.mrmime,R.drawable.scyther,R.drawable.jynx,R.drawable.electabuzz,R.drawable.magmar,R.drawable.pinsir,R.drawable.tauros,R.drawable.magikarp,
                R.drawable.gyarados,R.drawable.lapras,R.drawable.ditto,R.drawable.eevee,R.drawable.vaporeon,R.drawable.jolteon,R.drawable.flareon,R.drawable.porygon,R.drawable.omanyte,R.drawable.omastar,R.drawable.kabuto,R.drawable.kabutops,R.drawable.aerodactyl,
                R.drawable.snorlax,R.drawable.articuno,R.drawable.zapdos,R.drawable.moltres,R.drawable.dratini,R.drawable.dragonair,R.drawable.dragonite,R.drawable.mewtwo,R.drawable.mew,R.drawable.chikorita,R.drawable.bayleef,R.drawable.meganium,R.drawable.cyndaquil,
                R.drawable.quilava,R.drawable.typhlosion,R.drawable.totodile,R.drawable.croconaw,R.drawable.feraligatr,R.drawable.sentret,R.drawable.furret,R.drawable.hoothoot,R.drawable.noctowl,R.drawable.ledyba,R.drawable.ledian,R.drawable.spinarak,R.drawable.ariados,
                R.drawable.crobat,R.drawable.chinchou,R.drawable.lanturn,R.drawable.pichu,R.drawable.cleffa,R.drawable.igglybuff,R.drawable.togepi,R.drawable.togetic,R.drawable.natu,R.drawable.xatu,R.drawable.mareep,R.drawable.flaaffy,R.drawable.ampharos,R.drawable.bellossom,
                R.drawable.marill,R.drawable.azumarill,R.drawable.sudowoodo,R.drawable.politoed,R.drawable.hoppip,R.drawable.skiploom,R.drawable.jumpluff,R.drawable.aipom,R.drawable.sunkern,R.drawable.sunflora,R.drawable.yanma,R.drawable.wooper,R.drawable.quagsire,R.drawable.espeon,
                R.drawable.umbreon,R.drawable.murkrow,R.drawable.slowking,R.drawable.misdreavus,R.drawable.unown,R.drawable.wobbuffet,R.drawable.girafarig,R.drawable.pineco,R.drawable.forretress,R.drawable.dunsparce,R.drawable.gligar,R.drawable.steelix,R.drawable.snubbull,R.drawable.granbull,
                R.drawable.qwilfish,R.drawable.scizor,R.drawable.shuckle,R.drawable.heracross,R.drawable.sneasel,R.drawable.teddiursa,R.drawable.ursaring,R.drawable.slugma,R.drawable.magcargo,R.drawable.swinub,R.drawable.piloswine,R.drawable.corsola,R.drawable.remoraid,R.drawable.octillery,R.drawable.delibird,
                R.drawable.mantine,R.drawable.skarmory,R.drawable.houndour,R.drawable.houndoom,R.drawable.kingdra,R.drawable.phanpy,R.drawable.donphan,R.drawable.porygon2,R.drawable.stantler,R.drawable.smeargle,R.drawable.tyrogue,R.drawable.hitmontop,R.drawable.smoochum,
                R.drawable.elekid,R.drawable.magby,R.drawable.miltank,R.drawable.blissey,R.drawable.raikou,R.drawable.entei,R.drawable.suicune,R.drawable.larvitar,R.drawable.pupitar,R.drawable.tyranitar,R.drawable.lugia,R.drawable.ho_oh,R.drawable.celebi};
    }
    public void calculate(View view){
        firstEvolution=false;
        secondEvolution=false;
        candyTotal=Integer.parseInt(candyNum.getText().toString());
        beginText.setText("Calculate when ready!");
        evolution.setText("");
        label.setText("");
        beginText.setVisibility(View.INVISIBLE);
        label.setVisibility(View.VISIBLE);
        evolution.setVisibility(View.VISIBLE);
        if (list12.contains(poke)){
            if (candyTotal>=12)
            {
                remainder=(candyTotal/12);
                firstEvolution=true;
            }else{
                remainder=(12-candyTotal)/candyDivider;
                firstEvolution=false;}
        }
        if (list25.contains(poke)){
            if (candyTotal>=25) {
                remainder = (candyTotal / 25);
                firstEvolution = true;
            }else{
                remainder=(25-candyTotal)/candyDivider;
                firstEvolution=false;}
        }
        if (list50.contains(poke)){

            if (candyTotal>=50) {
                remainder = (candyTotal / 50);
                firstEvolution = true;
            }else{
                remainder=(50-candyTotal)/candyDivider;
                firstEvolution=false;}
        }
        if (list100.contains(poke)){
            if (candyTotal>=100) {
                remainder = (candyTotal / 100);
                firstEvolution = true;
            }else{
                remainder=(100-candyTotal)/candyDivider;
                firstEvolution=false;}
        }
        if (list400.contains(poke)){
            if (candyTotal>=400) {
                remainder = (candyTotal / 400);
                firstEvolution = true;
            }else{
                remainder=(400-candyTotal)/candyDivider;
                firstEvolution=false;}
        }
        if (list125.contains(poke)){

            if (candyTotal>=25) {
                remainder = (candyTotal / 25);
                firstEvolution = true;
            }else{
                remainder=(25-candyTotal)/candyDivider;
                firstEvolution=false;}

            if (candyTotal>=125) {
                remainderFull = (candyTotal / 125);
                secondEvolution = true;
            }else{
                remainderFull=(125-candyTotal)/candyDivider;
                secondEvolution=false;}
        }
        if (list62.contains(poke)){
            if (candyTotal>=12) {
                remainder = (candyTotal / 12);
                firstEvolution = true;
            }else{
                remainder=(12-candyTotal)/candyDivider;
                firstEvolution=false;}
            if (candyTotal>=62) {
                remainderFull = (candyTotal / 62);
                secondEvolution = true;
            }else{
                remainderFull=(62-candyTotal)/candyDivider;
                secondEvolution=false;}
        }
        if (list75.contains(poke)){
            if (candyTotal>=25) {
                remainder = (candyTotal / 25);
                firstEvolution = true;
            }else{
                remainder=(25-candyTotal)/candyDivider;
                firstEvolution=false;}
            if (candyTotal>=75) {
                remainderFull = (candyTotal / 75);
                secondEvolution = true;
            }else{
                remainderFull=(75-candyTotal)/candyDivider;
                secondEvolution=false;}
        }

        if (firstEvolution==true){
            doubleRemain=remainder;
            evolveTimes=(int) doubleRemain;
        }else{
            evolveTimes = (int) Math.ceil(remainder);
        }

        if (secondEvolution==true){
            fullEvoRemain=(int)remainderFull;
        }else{
            fullEvoRemain=(int) Math.ceil(remainderFull);
        }
            remain = (int) Math.ceil(remainder);


        if (list125.contains(poke) || list62.contains(poke)||list75.contains(poke))
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach " +pokenext);
            }
            if (secondEvolution==true){
                evolution.setText("You can evolve " +poke+" fully "+ fullEvoRemain + " times");
            }else{
                evolution.setText("You need " + fullEvoRemain + " catches to reach " +pokenextnext);
            }
        }
        if (list25.contains(poke) || list50.contains(poke))
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+ " " +evolveTimes + " times");
            }
            else{
                label.setText("You need " + evolveTimes + " catches to reach " +pokenext);
            }
        }
        if (list400.contains(poke)){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+ " " +evolveTimes+ " times");
            }
            else{
                label.setText("You need " + evolveTimes+ " catches to reach " + pokenext);
            }
        }
        if (list12.contains(poke)){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach " +pokenext);
            }
        }
        if (list100.contains(poke)){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach " +pokenext);
            }
        }
        if (listUnEvo.contains(poke)){
            label.setText(poke + " does not evolve further");
        }
        if (poke=="Scyther"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Scizor");
            }
        }
        if (poke=="Seadra"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Kingdra");
            }
        }
        if (poke=="Poliwhirl"){
                if (firstEvolution==true){
                    label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
                }else{
                    label.setText("You need " + evolveTimes + " catches to reach Politoed or Poliwrath");
                }
        }
        if (poke=="Slowpoke"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach SlowBro or Slowking");
            }
        }
        if (poke=="Onix"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Steelix");
            }
        }
        if (poke=="Gloom"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Bellossom or Vileplume");
            }
        }
        if (poke=="Sunkern"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Sunflora");
            }
        }
        if (poke=="Porygon"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Porygon2");
            }
        }
        if (poke=="Golbat"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Crobat");
            }
        }
        if (poke=="Chansey"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Blissey");
            }
        }
        if (poke=="Pichu")
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Pikachu");
            }
            if (secondEvolution==true){
                evolution.setText("You can evolve " +poke+" fully "+ fullEvoRemain + " times");
            }else{
                evolution.setText("You need " + fullEvoRemain + " catches to reach Raichu");
            }
        }
        if (poke=="Cleffa")
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Clefairy");
            }
            if (secondEvolution==true){
                evolution.setText("You can evolve " +poke+" fully "+ fullEvoRemain + " times");
            }else{
                evolution.setText("You need " + fullEvoRemain + " catches to reach Clefable");
            }
        }
        if (poke=="Igglybuff")
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Jigglypuff");
            }
            if (secondEvolution==true){
                evolution.setText("You can evolve " +poke+" fully "+ fullEvoRemain + " times");
            }else{
                evolution.setText("You need " + fullEvoRemain + " catches to reach Wigglytuff");
            }
        }
        if (poke=="Cleffa")
        {
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Clefairy");
            }
            if (secondEvolution==true){
                evolution.setText("You can evolve " +poke+" fully "+ fullEvoRemain + " times");
            }else{
                evolution.setText("You need " + fullEvoRemain + " catches to reach Clefable");
            }
        }
        if (poke=="Smoochum"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Jynx");
            }
        }
        if (poke=="Elekid"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Electrabuzz");
            }
        }
        if (poke=="Magby"){
            if (firstEvolution==true){
                label.setText("You can evolve " +poke+" "+ evolveTimes + " times ");
            }else{
                label.setText("You need " + evolveTimes + " catches to reach Magmar");
            }
        }

    }
}
