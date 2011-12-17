package Games;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Stack;

import Characters.AleaMovingCharacter;
import Characters.Figure;
import Characters.LoopMovingCharacter;
import Characters.NPC;
import Characters.Nadia;
import Objets.Beamer;
import Objets.Item;
import Objets.Key;
import Objets.Pacemaker;
import Objets.VitamineC;
import Sprites.Coord;
import Sprites.Sprite;
import Sprites.SpriteSheet;

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

    private static String[] exitStrings = {"nord", "sud", "est", "ouest", "haut", "bas"};
    private static String aleaS="";

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
        sSReserve, houssRoom, dehors/*, lol*/, egouts;

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
        //lol = new Room("dans la salle de t\u00e9l\u00e9portation","room/lol.jpg",Matrix.getS());
        egouts = new TransporterRoom("dans les \u00e9gouts","room/egout.jpg",Matrix.getS());

        // initialise room exits
        ArrayList<Coord> a1 = new ArrayList<Coord>();
        ArrayList<Coord> a2 = new ArrayList<Coord>();
        //ginetteRoom.setExit("est",new Coord(5,2),couloir4,null,false);
        a1.clear(); a2.clear();
        a1.add(new Coord(0,3));
        a2.add(new Coord(28,12));
        ginetteRoom.setExit("ouest", new ArrayList<Coord>(a1), new Coord(0,3), parc, new ArrayList<Coord>(a2), new Coord(28,12), false);

        /*couloir1.setExit("ouest",null,hall,new Coord(5,9),false);
        couloir1.setExit("nord",null,admine,new Coord(7,14),false);
        couloir1.setExit("sud",null,accueil,new Coord(6,1),false);
        couloir1.setExit("est",null,couloir2,null,false);

        couloir2.setExit("nord",null,repos,new Coord(4,11),false);
        couloir2.setExit("ouest",null,couloir1,null,false);
        couloir2.setExit("est",null,couloir3,null,false);

        couloir3.setExit("sud",null,salleCommune,new Coord(16,1),false);
        couloir3.setExit("nord",null,reserve,new Coord(4,11),true);
        couloir3.setExit("ouest",null,couloir2,null,false);
        couloir3.setExit("est",null,couloir4,null,false);

        couloir4.setExit("nord",null,infirmerie,new Coord(7,10),false);
        couloir4.setExit("sud",null,ginetteRoom,new Coord(5,2),false);
        couloir4.setExit("est",null,houssRoom,new Coord(0,3),false);
        couloir4.setExit("ouest",null,couloir3,null,false);

        infirmerie.setExit("sud",new Coord(7,10),couloir4,null,false);

        salleCommune.setExit("nord",new Coord(16,1),couloir3,null,false);
        */
        a1.clear(); a2.clear();
        a1.add(new Coord(7,14)); a1.add(new Coord(8,14));
        a2.add(new Coord(24,1)); a2.add(new Coord(25,1));
        salleCommune.setExit("sud", new ArrayList<Coord>(a1), new Coord(7,14), parc, new ArrayList<Coord>(a2), new Coord(24,1), false);
        /*
        salleCommune.setExit("ouest",new Coord(0,7),refectoire,new Coord(16,7),false);

        refectoire.setExit("est",new Coord(16,7),salleCommune,new Coord(0,7),false);
        refectoire.setExit("ouest",new Coord(),cuisine,new Coord(),false);

        */
        a1.clear(); a2.clear();
        a1.add(new Coord(24,1)); a1.add(new Coord(25,1));
        a2.add(new Coord(7,14)); a2.add(new Coord(8,14));
        parc.setExit("nord", new ArrayList<Coord>(a1), new Coord(24,1), salleCommune, new ArrayList<Coord>(a2), new Coord(7,14), false);
        /*
        //parc.setExit("est",new Coord(28,12),ginetteRoom,new Coord(0,3),false);

        hall.setExit("ouest",new Coord(),dehors,new Coord(),true);
        hall.setExit("est",new Coord(),couloir1,null,false);

        admine.setExit("sud",new Coord(),couloir1,null,false);
        admine.setExit("est",new Coord(),bDD,new Coord(),true);

        accueil.setExit("nord",new Coord(),couloir1,null,false);

        bDD.setExit("ouest",new Coord(),admine,new Coord(),true);

        cuisine.setExit("est",new Coord(),refectoire,new Coord(),false);

        repos.setExit("sud",new Coord(),couloir2,null,false);

        reserve.setExit("sud",new Coord(),couloir3,null,true);
        reserve.setExit("bas",new Coord(),sSReserve,new Coord(),false);

        sSReserve.setExit("haut",new Coord(),reserve,new Coord(),false);
        sSReserve.setExit("bas",new Coord(),egouts,new Coord(),false);

        houssRoom.setExit("ouest",new Coord(),couloir4,null,false);

        egouts.setExit("haut",new Coord(),sSReserve,new Coord(),false);*/

        /*lol.setExit("ginetteRoom",ginetteRoom,false);
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
        lol.setExit("egouts",egouts,false);*/

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
        //Room.setAllRoom("nkpc",lol);
        Room.setAllRoom("egouts",egouts);

        
        // declare the characters
        NPC houss, deub, daniel, quila, gaiver, stivi, mh, rosita, valerie, josiane, nirep;
        LoopMovingCharacter claude;
        AleaMovingCharacter bob;
        Nadia nadia;

        // create the characters
        houss = new NPC("Houss", "Papy Houss, un papy explosif...", "Papy Houss : Bonjour Ginette, comment allez-vous ?");
        deub = new NPC("Deubeuliou", "Papy Deubeuliou, expert en armement.", "Papy Deubeuliou : Bonjour Ginette, beau temps n'est-ce pas ?");
        daniel = new NPC("Daniel", "Jacques Daniel, un papy qui a soif...", "Papy Houss : Bonjour Ginette, \u00e7a vous dirait de prendre un verre ?");
        quila = new NPC("Quila", "Quila, un infirmier corrompu.", "Quila : Bonjour madame, besoin de quelque chose ?");
        gaiver = new NPC("Gaiver", "Papy Gaiver, un papy qui sait tout faire.", "Papy Gaiver : Bonjour Ginette, la famille, \u00e7a va ?");
        stivi = new NPC("Stivi", "Papy Stivi, un ami bien utile.", "Papy Stivi : Alors Ginette, o\u00f9 en est ton plan d'\u00e9vasion ?");
        mh = new NPC("MarieHelene", "Mamy Marie-H\u00e9l\u00e8ne, une gentille mamy", "Mamy Marie-H\u00e9l\u00e8ne : Bonjour Ginette, avez-vous trouv\u00e9 la fourche ?");
        rosita = new NPC("Rosita", "Mamy Rosita, une gentille mamy (tr\u00e9s gentille...)", "Mamy Rosita : Hola Ginette, commo estas ?");
        valerie = new NPC("Valerie", "Mamy Val\u00e9rie, une mamy sympa", "Mamy Val\u00e9rie : H\u00e9 Ginette, cette nuit j'ai r\u00eav\u00e9 d'un pot de moutarde g\u00e9ant !");
        josiane = new NPC("Josiane", "Mamy Josiane, une joyeuse mamy.", "Mamy Josiane : Salut Ginette, vous voulez jouer au scrabble ?");
        nirep = new NPC("Nirep", "M. Nirep, directeur de la Rivi\u00e8re du Renard.", "Un problème madame ?");
        claude = new LoopMovingCharacter("Claude", "Papy Claude, un gentil papy.", "Papy Claude : Bonjour Ginette, vous n'auriez pas vu la clouteuse \u00e0 eau ?");
        nadia = new Nadia("Nadia", "Nadia, infirmi\u00e8re en chef.", "Nadia : Bonjour Mme Ginette, que faites-vous en dehors de votre chambre ?", false);
        bob = new AleaMovingCharacter("Bob", "Bob, un infirmier comme les autres.", "Bob : ...");

        // initialise the current room for moving characters
        claude.setCurrentRoom(salleCommune);
        nadia.setCurrentRoom(infirmerie);
        bob.setCurrentRoom(parc);

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
        salleCommune.getCharacters().addCharacter("Deubeuliou", deub);
        salleCommune.getCharacters().addCharacter("Gaiver", gaiver);
        salleCommune.getCharacters().addCharacter("Stivi", stivi);
        salleCommune.getCharacters().addCharacter("Rosita", rosita);
        salleCommune.getCharacters().addCharacter("Valerie", valerie);
        refectoire.getCharacters().addCharacter("MarieHelene", mh);
        refectoire.getCharacters().addCharacter("Daniel", daniel);
        refectoire.getCharacters().addCharacter("Josiane", josiane);
        reserve.getCharacters().addCharacter("Quila", quila);
        repos.getCharacters().addCharacter("Bob", bob);
        bDD.getCharacters().addCharacter("Nirep", nirep);
        infirmerie.getCharacters().addCharacter("Nadia", nadia);

        // add the characters to the nPCList
        nPCList.add(houss);
        nPCList.add(claude);
        nPCList.add(deub);
        nPCList.add(gaiver);
        nPCList.add(stivi);
        nPCList.add(rosita);
        nPCList.add(valerie);
        nPCList.add(mh);
        nPCList.add(daniel);
        nPCList.add(josiane);
        nPCList.add(quila);
        nPCList.add(bob);
        nPCList.add(nirep);
        nPCList.add(nadia);

        
        // declare the items
        Item verre, fourchette, domino, balle, seringue, canne, /*fourche,*/ masse;
        Pacemaker toctoc, tictic;
        VitamineC psss, psss2;
        Beamer pouet;

        Key reserveKey, bDDKey, exitKey;

        // create the items
        verre = new Item("verre","objet en verre pour boire de l'eau",12,11,1);
        fourchette = new Item("fourchette","outil m\u00e9tallique pour manger",5,7,1);
        domino = new Item("domino","objet en plastique pour jouer aux dominos", 6,2,1);
        balle = new Item("balle", "objet en caoutchouc pour assommer \u00e0 distance un \u00e9nemi",20,10,1);
        seringue = new Item("seringue","objet pointu utilis\u00e9 pour s'administrer un liquide",7,5,1);
        canne = new Item("canne","objet en bois pour marcher",19,10,1);
        //fourche = new Item("FOURCHE","parce que c'est bien utile d'en avoir une",999999999,99999999,1000);
        masse = new Item("masse","truc lourd",0,99,1);
        toctoc = new Pacemaker("pacemaker","objet pouvant augmenter la vitesse du coeur :" + "\n"
        		+ "augmente le poids maximum pouvant \u00eatre port\u00e9", 25,7,1);
        tictic = new Pacemaker("pacemaker","objet pouvant augmenter la vitesse du coeur :" + "\n"
                + "augmente le poids maximum pouvant \u00eatre port\u00e9", 25,7,1);
        psss = new VitamineC("VitamineC","objet redonnant des forces :" + "\n"
        		+ "augmente le nombre de pas restant", 10,2,1);
        psss2 = new VitamineC("VitamineC","objet redonnant des forces :" + "\n"
                + "augmente le nombre de pas restant", 10,2,1);
        pouet = new Beamer("teleporteur","permet de se t\u00e9l\u00e9porter dans une piece precedemment visit\u00e9\u00e9 : " + "\n"
        		+"chargez le dans une piece ( utiliser) et r\u00e9utiliser le dans une autre pi\u00e8ce",10,5,1);
        reserveKey = new Key("clefReserve","la cl\u00e9 de la r\u00e9serve", 0,4,1, reserve.getDoor("sud"));
        bDDKey = new Key("clefDirecteur","la cl\u00e9 du bureau du directeur", 10,4,1, bDD.getDoor("ouest"));
        exitKey = new Key("clefSortie","la cl\u00e9 de la porte de sortie de la maison de retraite", 0,4,1, hall.getDoor("ouest"));

        // add the items to the rooms
        ginetteRoom.getItems().addItem("verre", verre);
        ginetteRoom.getItems().addItem("teleporteur", pouet);
        couloir4.getItems().addItem("canne", canne);
        infirmerie.getItems().addItem("seringue", seringue);
        infirmerie.getItems().addItem("VitamineC", psss);
        cuisine.getItems().addItem("VitamineC", psss2);
        salleCommune.getItems().addItem("domino", domino);
        refectoire.getItems().addItem("fourchette", fourchette);
        refectoire.getItems().addItem("verre", verre);
        parc.getItems().addItem("balle", balle);
        //lol.getItems().addItem("fourche",fourche);
        cuisine.getItems().addItem("masse",masse);
        cuisine.getItems().addItem("pacemaker", toctoc);

        accueil.getItems().addItem("clefReserve", reserveKey);
        bDD.getItems().addItem("clefSortie", exitKey);

        // add the items to the characters bags
        houss.getBag().addItem("balle", balle);
        quila.getBag().addItem("clefDirecteur", bDDKey);
        rosita.getBag().addItem("pacemaker", tictic);
        
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
     * 
     * @return aleaS
     */
    public static String getAleaS()
    {
        return aleaS;
    } //getAleas(.)
    
    /**
     * Replace aleaS
     */
    public static void setAleaS(String s)
    {
        aleaS=s;
    } //setAleaS(.)

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
    	Figure f = player.getFigure();
    	
    	int x = player.getX();
		int y = player.getY();

		if(direction.equals("est")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.goRight1);
		}
		else if(direction.equals("ouest")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.goLeft1);
		}
		else if(direction.equals("nord")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - Matrix.CASE_SIZE/4));
			f.setPosture(Sprite.goUp1);
		}
		else if(direction.equals("sud")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + Matrix.CASE_SIZE/4));
			f.setPosture(Sprite.goDown1);
		}
		
    	setChanged();
    	notifyObservers(f.clone());

		if(direction.equals("est")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + Matrix.CASE_SIZE/2, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showRight);
		}
		else if(direction.equals("ouest")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - Matrix.CASE_SIZE/2, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showLeft);
		}
		else if(direction.equals("nord")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - Matrix.CASE_SIZE/2));
			f.setPosture(Sprite.showUp);
		}
		else if(direction.equals("sud")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + Matrix.CASE_SIZE/2));
			f.setPosture(Sprite.showDown);
		}
		
    	setChanged();
    	notifyObservers(f.clone());

		if(direction.equals("est")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 + 3 * Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.goRight2);
		}
		else if(direction.equals("ouest")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3 - 3 * Matrix.CASE_SIZE/4, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.goLeft2);
		}
		else if(direction.equals("nord")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 - 3 * Matrix.CASE_SIZE/4));
			f.setPosture(Sprite.goUp2);
		}
		else if(direction.equals("sud")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5 + 3 * Matrix.CASE_SIZE/4));
			f.setPosture(Sprite.goDown2);
		}
		
    	setChanged();
    	notifyObservers(f.clone());

		if(direction.equals("est")) {
			f.setCoord(new Coord((x + 1) * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showRight);
		}
		else if(direction.equals("ouest")) {
			f.setCoord(new Coord((x - 1) * Matrix.CASE_SIZE - 3, y * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showLeft);
		}
		else if(direction.equals("nord")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, (y - 1) * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showUp);
		}
		else if(direction.equals("sud")) {
			f.setCoord(new Coord(x * Matrix.CASE_SIZE - 3, (y + 1) * Matrix.CASE_SIZE - 5));
			f.setPosture(Sprite.showDown);
		}
		
    	setChanged();
    	notifyObservers(f.clone());
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
     * Return the ending message for the player.
     * @return "\n" + "GAME OVER" + "\n" + "Vous \u00eates morte..." + "\n" + "Vous n'avez pas r\u00e9ussi \u00e0 vous \u00e9chapper de la maison de retraite."
     */
    public String getGameOverString()
    {
        return "\n" +"GGGGGGG   AAAAAAA   MM             MM   EEEEEEE          OOOOOOO   VV         VV   EEEEEEE   RRRRRRR"+"\n"
                    +"GGGGGGG   AAAAAAA   MMM        MMM   EEEEEEE          OOOOOOO   VV         VV   EEEEEEE   RRRRRRR"+"\n"
                    +"GG              AA      AA   MMMM   MMMM   EE                   OO       OO     VV     VV     EE            RR      RR"+"\n"
                    +"GG              AAAAAAA   MM  MMMM MM   EEEEEE            OO       OO     VV     VV     EEEEEE     RRRRRRR"+"\n"
                    +"GG       GG   AAAAAAA   MM    MM    MM   EE                   OO       OO       VVVV        EE            RR  RR"+"\n"
                    +"GGGGGGG   AA      AA   MM             MM   EEEEEEE          OOOOOOO        VVVV        EEEEEEE   RR    RR"+"\n"
                    +"GGGGGGG   AA      AA   MM             MM   EEEEEEE          OOOOOOO          VV          EEEEEEE   RR       RR"+"\n"
                    +"GAME OVER" + "\n" + "Vous \u00eates morte..." + "\n" + "Vous n'avez pas r\u00e9ussi \u00e0 vous \u00e9chapper de la maison de retraite."+"\n";

    }
    
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
