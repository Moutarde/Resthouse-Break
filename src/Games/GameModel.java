package Games;

import java.util.Observable;
import java.util.Stack;
import java.util.ArrayList;
import Objets.*;
import Sprites.Coord;
import Sprites.Sprite;
import Sprites.SpriteSheet;
import Characters.*;

/**
 * GameModel represents the model of the game. This 
 * 
 * @author Charlet Pierre, Kniebihler Nicolas, Provost Kevin
 * @version 1.0 (mai 2009)
 */
public class GameModel extends Observable
{
    private Stack<Room> backRoom;
    private Player player;
    private ArrayList<NPC> nPCList;
    private SpriteSheet spriteSheet;

    private static String[] exitStrings = {"nord", "sud", "est", "ouest"};

    /**
     * Constructor for objects of the class GameModel.
     * Create a new game model : initialise and creates the rooms, 
     * and create the player.
     */
    public GameModel()
    {
        nPCList = new ArrayList<NPC>();
        createRooms();
        spriteSheet = new SpriteSheet("spriteSheet.png", 32*3, 32*4);

		Figure f = new Figure(spriteSheet.getSprite(2, 5), new Coord(3 * Matrix.CASE_SIZE - 3, 3 * Matrix.CASE_SIZE - 5), Sprite.showDown);
        player = new Player(Room.getAllRoom("gr"), "Mamy Ginette", 50, 100, 100, 3, 3, f);
    } //GameModel()

    /**
     * Create all the rooms and link their exits together.
     * Create all items and link them to the rooms where they are.
     */
    private void createRooms()
    {   
        // declare the rooms
        Room ginetteRoom, couloir1, couloir2, couloir3, couloir4, infirmerie, salleCommune,
        refectoire, parc, hall, admine, accueil, bDD, cuisine, repos, reserve,
        sSReserve, houssRoom, dehors, lol, egouts;

        // create the rooms
        ginetteRoom = new Room("dans la chambre de mamy Ginette","room/ginetteRoom.jpg",Matrix.getGr());
        couloir1 = new Room("dans le couloir","room/couloir1.jpg",Matrix.getS());
        couloir2 = new Room("dans le couloir","room/couloir2.jpg",Matrix.getS());
        couloir3 = new Room("dans le couloir","room/couloir3.jpg",Matrix.getS());
        couloir4 = new Room("dans le couloir","room/couloir4.jpg",Matrix.getS());
        infirmerie = new Room("dans l'infirmerie","room/infirmerie.jpg",Matrix.getInf());
        salleCommune = new Room("dans la salle commune","room/salleCommune.jpg",Matrix.getSC());
        refectoire = new Room("dans le r\u00e9fectoire","room/refectoire.jpg",Matrix.getRef());
        parc = new Room("dans le parc","room/parc.jpg",Matrix.getParc());
        hall = new Room("dans le hall","room/hall.jpg",Matrix.getHall());
        admine = new Room("\u00e0 l'administration","room/admine.jpg",Matrix.getAdmine());
        accueil = new Room("\u00e0 l'accueil","room/accueil.jpg",Matrix.getAccueil());
        bDD = new Room("dans le bureau du directeur","room/bDD.jpg",Matrix.getBDD());
        cuisine  = new Room("dans la cuisine","room/cuisine.jpg",Matrix.getCuisine());
        repos = new Room("dans la salle de repos du personel","room/repos.jpg",Matrix.getRepos());
        reserve = new Room("dans la r\u00e9serve","room/reserve.jpg",Matrix.getReserve());
        sSReserve = new Room("dans le sous-sol de la r\u00e9serve","room/sSR.jpg",Matrix.getSSR());
        houssRoom = new Room("dans la chambre de papy Houss","room/houssRoom.jpg",Matrix.getHR());
        dehors = new Room("\u00e0 l'ext\u00e9rieur","room/dehors.jpg",Matrix.getS());
        lol = new Room("dans la salle de t\u00e9l\u00e9portation","room/lol.jpg",Matrix.getS());
        egouts = new TransporterRoom("dans les \u00e9gouts","room/egout.jpg",Matrix.getS());

        // initialise room exits
        ginetteRoom.setExit("est",couloir4,false);
        ginetteRoom.setExit("ouest",parc,false);

        couloir1.setExit("ouest",hall,false);
        couloir1.setExit("nord",admine,false);
        couloir1.setExit("sud",accueil,false);
        couloir1.setExit("est",couloir2,false);

        couloir2.setExit("nord",repos,false);
        couloir2.setExit("ouest",couloir1,false);
        couloir2.setExit("est",couloir3,false);

        couloir3.setExit("sud",salleCommune,false);
        couloir3.setExit("nord",reserve,true);
        couloir3.setExit("ouest",couloir2,false);
        couloir3.setExit("est",couloir4,false);

        couloir4.setExit("nord",infirmerie,false);
        couloir4.setExit("sud",ginetteRoom,false);
        couloir4.setExit("est",houssRoom,false);
        couloir4.setExit("ouest",couloir3,false);

        infirmerie.setExit("sud",couloir4,false);

        salleCommune.setExit("nord", couloir3,false);
        salleCommune.setExit("sud",parc,false);
        salleCommune.setExit("ouest",refectoire,false);

        refectoire.setExit("est",salleCommune,false);
        refectoire.setExit("ouest",cuisine,false);

        parc.setExit("nord",salleCommune,false);
        parc.setExit("est",ginetteRoom,false);

        hall.setExit("ouest",dehors,true);
        hall.setExit("est", couloir1,false);

        admine.setExit("sud", couloir1,false);
        admine.setExit("est", bDD,true);

        accueil.setExit("nord", couloir1,false);

        bDD.setExit("ouest",admine,true);

        cuisine.setExit("est",refectoire,false);

        repos.setExit("sud", couloir2,false);

        reserve.setExit("sud", couloir3,true);
        reserve.setExit("bas", sSReserve,false);

        sSReserve.setExit("haut",reserve,false);
        sSReserve.setExit("bas",egouts,false);

        houssRoom.setExit("ouest",couloir4,false);

        egouts.setExit("haut",sSReserve,false);

        lol.setExit("ginetteRoom",ginetteRoom,false);
        lol.setExit("infirmerie",infirmerie,false);
        lol.setExit("salleCommune",salleCommune,false);
        lol.setExit("refectoire",refectoire,false);
        lol.setExit("parc",parc,false);
        lol.setExit("couloir1",couloir1,false);
        lol.setExit("couloir2",couloir2,false);
        lol.setExit("couloir3",couloir3,false);
        lol.setExit("couloir4",couloir4,false);
        lol.setExit("hall",hall,false);
        lol.setExit("admine",admine,false);
        lol.setExit("accueil",accueil,false);
        lol.setExit("bdd",bDD,false);
        lol.setExit("cuisine",cuisine,false);
        lol.setExit("repos",repos,false);
        lol.setExit("reserve",reserve,false);
        lol.setExit("sSReserve",sSReserve,false);
        lol.setExit("houssRoom",houssRoom,false);
        lol.setExit("dehors",dehors,false);
        lol.setExit("egouts",egouts,false);

        // add the rooms to the list of all the rooms : allRoom
        Room.setAllRoom("gr",ginetteRoom);
        Room.setAllRoom("inf",infirmerie);
        Room.setAllRoom("sc",salleCommune);
        Room.setAllRoom("ref",refectoire);
        Room.setAllRoom("parc",parc);
        Room.setAllRoom("c1",couloir1);
        Room.setAllRoom("c2",couloir2);
        Room.setAllRoom("c3",couloir3);
        Room.setAllRoom("c4",couloir4);
        Room.setAllRoom("hall",hall);
        Room.setAllRoom("admine",admine);
        Room.setAllRoom("accueil",accueil);
        Room.setAllRoom("bdd",bDD);
        Room.setAllRoom("cuisine",cuisine);
        Room.setAllRoom("repos",repos);
        Room.setAllRoom("reserve",reserve);
        Room.setAllRoom("ssr",sSReserve);
        Room.setAllRoom("hr",houssRoom);
        Room.setAllRoom("dehors",dehors);
        Room.setAllRoom("nkpc",lol);
        Room.setAllRoom("egouts",egouts);

        
        // declare the characters
        NPC houss;
        LoopMovingCharacter claude;
        AleaMovingCharacter nadia;

        // create the characters
        houss = new NPC("Houss", "Papy Houss, expert en explosifs...", "Papy Houss : Bonjour Ginette, comment vas-tu ?");
        claude = new LoopMovingCharacter("Claude", "Papy Claude, un gentil papy.", "Papy Claude : Bonjour Ginette, vous n'auriez pas vu la clouteuse \u00e0 eau ?");
        nadia = new AleaMovingCharacter("Nadia", "Nadia, infirmi\u00e8re en chef.", "Nadia : Bonjour Mme Ginette, que faites-vous en dehors de votre chambre ?");

        // initialise the current room for moving characters
        claude.setCurrentRoom(salleCommune);
        nadia.setCurrentRoom(infirmerie);

        // initialise the loop for moving characters
        claude.addDirection("nord");
        claude.addDirection("sud");
        claude.addDirection("ouest");
        claude.addDirection("est");
        claude.addDirection("sud");
        claude.addDirection("nord");

        // add the characters to the rooms
        houssRoom.getCharacters().addCharacter("Houss", houss);
        salleCommune.getCharacters().addCharacter("Claude", claude);
        infirmerie.getCharacters().addCharacter("Nadia", nadia);

        // add the characters to the nPCList
        nPCList.add(houss);
        nPCList.add(claude);
        nPCList.add(nadia);

        
        // declare the items
        Item verre, fourchette, domino, balle, seringue, canne, fourche, masse;
        Pacemaker toctoc;
        VitamineC psss;
        Beamer pouet;

        Key reserveKey, bDDKey, exitKey;

        // create the items
        verre = new Item("verre","objet en verre pour boire de l'eau",12,11,1);
        fourchette = new Item("fourchette","outil m\u00e9tallique pour manger",5,7,1);
        domino = new Item("domino","objet en plastique pour jouer aux dominos", 6,2,1);
        balle = new Item("balle", "objet en caoutchouc pour assommer \u00e0 distance un \u00e9nemi",20,10,1);
        seringue = new Item("seringue","objet pointu utilis\u00e9 pour s'administrer un liquide",7,5,1);
        canne = new Item("canne","objet en bois pour marcher",19,10,1);
        fourche = new Item("FOURCHE","parce que c'est bien utile d'en avoir une",999999999,99999999,1000);
        masse = new Item("masse","truc lourd",0,99,1);
        toctoc = new Pacemaker("pacemaker","objet pouvant augmenter la vitesse du coeur :" + "\n"
            + "augmente le poids maximum pouvant \u00eatre port\u00e9", 25,7,1);
        psss = new VitamineC("VitamineC","objet redonnant des forces :" + "\n"
            + "augmente le nombre de pas restant", 10,2,1);
        pouet = new Beamer("teleporteur","permet de se t\u00e9l\u00e9porter dans une piece precedemment visit\u00e9\u00e9 : " + "\n"
            +"chargez le dans une piece ( utiliser) et r\u00e9utiliser le dans une autre pi\u00e8ce",10,5,1);
        reserveKey = new Key("clefReserve","la cl\u00e9 de la r\u00e9serve", 0,4,1, reserve.getDoor("sud"));
        bDDKey = new Key("clefDirecteur","la cl\u00e9 du bureau du directeur", 0,4,1, bDD.getDoor("ouest"));
        exitKey = new Key("clefSortie","la cl\u00e9 de la porte de sortie de la maison de retraite", 0,4,1, hall.getDoor("ouest"));

        // add the items to the rooms
        ginetteRoom.getItems().addItem("verre", verre);
        ginetteRoom.getItems().addItem("teleporteur", pouet);
        couloir4.getItems().addItem("canne", canne);
        infirmerie.getItems().addItem("seringue", seringue);
        infirmerie.getItems().addItem("VitamineC", psss);
        salleCommune.getItems().addItem("domino", domino);
        refectoire.getItems().addItem("fourchette", fourchette);
        refectoire.getItems().addItem("verre", verre);
        parc.getItems().addItem("balle", balle);
        lol.getItems().addItem("fourche",fourche);
        cuisine.getItems().addItem("masse",masse);
        cuisine.getItems().addItem("pacemaker", toctoc);

        accueil.getItems().addItem("clefReserve", reserveKey);
        reserve.getItems().addItem("clefDirecteur", bDDKey);
        bDD.getItems().addItem("clefSortie", exitKey);

        // add the items to the characters bags
        houss.getBag().addItem("balle", balle);

        
        // create a stack with the rooms where the player goes, to go back.
        backRoom = new Stack<Room>();
    } //createRooms()

    /**
     * @return The current room.
     */
    public Player getPlayer()
    {
        return player;
    } //getCurrentRoom()

    /**
     * @return the backRoom Stack.
     */
    public Stack<Room> getBackRoom()
    {
        return backRoom;
    } //getCurrentRoom()

    /**
     * @return The list of all characters.
     */
    public ArrayList<NPC> getNPCList()
    {
        return nPCList;
    } //getNPCList()

    /**
     * @return The list of all the exit strings.
     */
    public static String[] getExitStrings()
    {
        return exitStrings;
    }

    /**
     * Replace the current room by the room in parameter,
     * and notify the change to the observers.
     */
    public void goRoom(Room nextRoom)
    {
        backRoom.push(player.getCurrentRoom());
        player.goRoom(nextRoom);
        player.decreaseStepNb(1);
        setChanged();
        notifyObservers();
    } //goRoom(.)

    public void walk(String direction) {
    	this.moveAnimation(direction);
    	player.walk(direction);
    }

    private void moveAnimation(String direction) {
    	setChanged();
    	notifyObservers("move " + direction);
	}

	/**
     * Replace the current room by the last room
     * and notify the change to the observers.
     */
    public void goBack()
    {
        Room last = backRoom.pop();
        player.goRoom(last);
        player.increaseStepNb(1);
        setChanged();
        notifyObservers();
    } //goBack()

    /**
     * @return The message that informs the player that he has taken the item.
     */
    public String getTakeItemString(String item)
    {
        return "\n" + "Vous mettez l'objet " + item + " dans votre sac.";
    } //getTakeItemString(.)

    /**
     * @return The message that informs the player that he has dropen the item.
     */
    public String getDropItemString(String item)
    {
        return "\n" + "Vous posez l'objet " + item + " " + player.getCurrentRoom().getShortDescription() + ".";
    } //getDropItemString(.)

    /**
     * @return The message that informs the player that he has bought the item.
     */
    public String getBuyItemString(String item)
    {
        return "\n" + "Vous achetez l'objet " + item + " \u00e0 " + player.getLastTalk().getNPCName() + ".";
    }

    /**
     * Return a message which give the number of teeth.
     * @return "Nombre de dents en or : ???"
     */
    public String getTeethNbString(int teeth)
    {
        return "\n" + "Nombre de dents en or : " + teeth + "." + "\n";
    } //getTeethNbString(.)

    /**
     * Return the opening message for the player.
     * @return "Bienvenue \u00e0 la rivi\u00e8re du renard,
     *          une maison de retraite calme et paisible.
     *          Tapez '15' si vous avez besoin d'aide."
     */
    public String getWelcomeString() 
    {
        return "\n" + "Bienvenue \u00e0 la rivi\u00e8re du renard," + "\n" +
        "une maison de retraite calme et paisible." + "\n" +
        "Tapez '15' si vous avez besoin d'aide." + "\n";
    } //getWelcomeString()

    /**
     * Return the ending message for the player.
     * @return "Vous ne regarderez plus vos grand-parents de la m\u00eame fa\u00e7on..."
     */
    public String getGoodByeString()
    {
        return "\n"+"Vous ne regarderez plus vos grand-parents de la m\u00eame fa\u00e7on...";
    } //getGoodByeString()

    /**
     * Return the help message for the player.
     * @return "Un beau pompier arrive et vous dit : "
     */
    public String getHelpString()
    {
        return "\n"+"Un beau pompier arrive" + "\n" + "et vous dit :" + "\n";
    } //getHelpString()

    /**
     * @return The help message for the player.
     */
    public String getToHelpString()
    {
        return "\n"+"ginette room : gr                   infirmerie : inf"
        +"\n"+"salle commune : sc             refectoire : ref"
        +"\n"+"parc : parc                              hall : hall"
        +"\n"+"couloir1 : c1                           couloir2 : c2"
        +"\n"+"couloir3 : c3                           couloir4 : c4"
        +"\n"+"administration : admine      cuisine : cuisine"
        +"\n"+"accueil : accueil                    salleRepos : repos"
        +"\n"+"bureau directeur : bdd         reserve : reserve"
        +"\n"+"sous sol reserve : ssr          houss room :hr"
        +"\n"+"dehors : dehors";
    } //getToHelpString()

    /**
     * @return The description of the current room.
     */
    public String getLocationInfo()
    {
        return player.getCurrentRoom().getLongDescription();
    } //getLocationInfo()

    /**
     * Return the description of the current room when the player
     * enters the command "voir".
     * @return The description of the current room.
     */
    public String getVoirString()
    {
        return getLocationInfo();
    } //getVoirString()

    /**
     * Return a strange message when the player enters the command "manger".
     * @return "Vous avez d\u00e9ja mang\u00e9, vous n avez plus faim."
     */
    public String getMangerString()
    {
        return "\n"+"Vous avez d\u00e9ja mang\u00e9, vous n'avez plus faim" + "\n";
    } //getMangerString()

    /**
     * Return a strange message when the player enters the command "manger".
     * @return "Vous avez d\u00e9ja utilis\u00e9 un objet, ca suffit."
     */
    public String getuseItemString()
    {
        return "\n"+"Quel objet tu veux que j'utilise ?" + "\n";
    } //getuseItemString()

    /**
     * Return a message which give the carried weight.
     * @return "Poids port\u00e9 : ???"
     */
    public String getCarriedWeightString(int weight)
    {
        return "\n" + "Poids port\u00e9 : " + weight + "." + "\n";
    } //getCarriedWeightString(.)

    /**
     * @return The message that informs the player that he has eaten the item.
     */
    public String getEatString(String item)
    {
        return "\n" + "Vous mangez l'objet " + item + "." + "\n";
    } //getEatString(.)

    /**
     * @return The message that informs the player that he has use the item.
     */
    public String getuseString(String item)
    {
        return "\n" + "Vous utilisez l'objet " + item + "." + "\n";
    } //getuseItemString(.)

} //GameModel