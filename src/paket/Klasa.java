package paket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Klasa {

	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		ArrayList<Player> playerList = new ArrayList<>();
		Player[] playerArray;
		ArrayList<Player> mvpList = new ArrayList<>();
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String inputPath = reader.readLine();

			FileReader fileReader = new FileReader(inputPath);
			Object inputObject = parser.parse(fileReader);
			JSONObject jsonObject = (JSONObject) inputObject;
			JSONArray jsonArray = (JSONArray) jsonObject.get("players");

			Iterator<JSONObject> playerIterator = jsonArray.iterator();

			while (playerIterator.hasNext()) {

				JSONObject playerObject = (JSONObject) playerIterator.next();
				Player player = new Player();

				player.setId((String) playerObject.get("id"));
				player.setFirstname((String) playerObject.get("firstname"));
				player.setLastname((String) playerObject.get("lastname"));
				player.setTeam((String) playerObject.get("team"));
				player.setGp((int) (long) playerObject.get("gp"));
				player.setMin((int) (long) playerObject.get("min"));
				player.setPts((int) (long) playerObject.get("pts"));
				player.setOreb((int) (long) playerObject.get("oreb"));
				player.setDreb((int) (long) playerObject.get("dreb"));
				player.setAsts((int) (long) playerObject.get("asts"));
				player.setStl((int) (long) playerObject.get("stl"));
				player.setBlk((int) (long) playerObject.get("blk"));
				player.setTo((int) (long) playerObject.get("to"));
				player.setPf((int) (long) playerObject.get("pf"));
				player.setFga((int) (long) playerObject.get("fga"));
				player.setFgm((int) (long) playerObject.get("fgm"));
				player.setFta((int) (long) playerObject.get("fta"));
				player.setFtm((int) (long) playerObject.get("ftm"));
				player.setTpa((int) (long) playerObject.get("tpa"));
				player.setTpm((int) (long) playerObject.get("tpm"));

				JSONArray jsonPosArray = (JSONArray) playerObject.get("pos");
				Iterator<String> posIterator = jsonPosArray.iterator();
				ArrayList<String> posArray = new ArrayList<>();
				while (posIterator.hasNext()) {
					posArray.add((String) posIterator.next());
				}
				player.setPos(posArray);
				int result = player.getPts() + player.getOreb() + player.getDreb() + player.getAsts() + player.getStl()
						+ player.getBlk() - player.getFga() + player.getFgm() - player.getFta() + player.getFtm()
						- player.getTo();
				player.setResult(result);
				playerList.add(player);
			}
			playerArray = new Player[playerList.size()];
			playerArray = playerList.toArray(playerArray);

			Player swapTemp;
			for (int i = 0; i < playerArray.length; i++) {
				for (int j = i; j < playerArray.length; j++) {
					if (playerArray[i].getResult() < playerArray[j].getResult()) {
						swapTemp = playerArray[i];
						playerArray[i] = playerArray[j];
						playerArray[j] = swapTemp;
					}
				}
			}

			int brojMvp = 0;
			Player mvp = playerArray[0];
			boolean bool = false;
			boolean bool1 = false;
			for (int i = 0; i < playerArray.length; i++) {
				if (playerArray[i] == null) {
					continue;
				}
				for (int j = 0; j < playerArray[i].getPos().size(); j++) {
					if (playerArray[i].getPos().contains("SG")) {
						out:
						for (int j2 = 0; j2 < mvpList.size(); j2++) {
							for (int k = j2+1; k < mvpList.size(); k++) {
								if(playerArray[i].getTeam().equals(mvpList.indexOf(j2))&&playerArray[i].getTeam().equals(mvpList.indexOf(k))){
									bool1=true;
									break out;
								}
							}
						}
						mvpList.add(playerArray[i]);
						brojMvp++;
						playerArray[i] = null;
						bool = true;
						break;
					}
				}
				if (bool) {
					bool = false;
					break;
				}
			}
			for (int i = 0; i < playerArray.length; i++) {
				if (playerArray[i] == null) {
					continue;
				}
				for (int j = 0; j < playerArray[i].getPos().size(); j++) {
					if (playerArray[i].getPos().contains("PG")) {
						mvpList.add(playerArray[i]);
						brojMvp++;
						playerArray[i] = null;
						bool = true;
						break;
					}
				}
				if (bool) {
					bool = false;
					break;
				}
			}
			for (int i = 0; i < playerArray.length; i++) {
				if (playerArray[i] == null) {
					continue;
				}
				for (int j = 0; j < playerArray[i].getPos().size(); j++) {
					if (playerArray[i].getPos().contains("SF")) {
						mvpList.add(playerArray[i]);
						brojMvp++;
						playerArray[i] = null;
						bool = true;
						break;
					}
				}
				if (bool) {
					bool = false;
					break;
				}
			}
			for (int i = 0; i < playerArray.length; i++) {
				if (playerArray[i] == null) {
					continue;
				}
				for (int j = 0; j < playerArray[i].getPos().size(); j++) {
					if (playerArray[i].getPos().contains("PF")) {
						mvpList.add(playerArray[i]);
						brojMvp++;
						playerArray[i] = null;
						bool = true;
						break;
					}
				}
				if (bool) {
					bool = false;
					break;
				}
			}
			for (int i = 0; i < playerArray.length; i++) {
				if (playerArray[i] == null) {
					continue;
				}
				for (int j = 0; j < playerArray[i].getPos().size(); j++) {
					if (playerArray[i].getPos().contains("C")) {
						mvpList.add(playerArray[i]);
						brojMvp++;
						playerArray[i] = null;
						bool = true;
						break;
					}
				}
				if (bool) {
					bool = false;
					break;
				}
			}
			if (brojMvp < 5) {
				System.out.println("Broj igraca u dream team-u je nedovoljan(" + brojMvp + ")");
				System.exit(0);
			}

			JSONObject outputObject = new JSONObject();
			JSONObject outputMvpObject = new JSONObject();

			Iterator<Player> mvpIterator = mvpList.iterator();
			FileWriter writer = new FileWriter("autputdzejson.json");

			outputMvpObject.put("id", mvp.getId());
			outputMvpObject.put("firstname", mvp.getFirstname());
			outputMvpObject.put("lastname", mvp.getLastname());
			outputMvpObject.put("team", mvp.getTeam());
			JSONArray mvpPosArray = new JSONArray();
			Iterator<String> mvpPosIterator = mvp.getPos().iterator();
			while (mvpPosIterator.hasNext()) {
				mvpPosArray.add(mvpPosIterator.next());
			}
			outputMvpObject.put("pos", mvpPosArray);
			outputObject.put("MVP", outputMvpObject);

			JSONArray outputDreamTeamArray = new JSONArray();
			while (mvpIterator.hasNext()) {
				JSONObject outputDreamTeamObject = new JSONObject();
				Player innerPlayer = mvpIterator.next();
				outputDreamTeamObject.put("id", innerPlayer.getId());
				outputDreamTeamObject.put("firstname", innerPlayer.getFirstname());
				outputDreamTeamObject.put("lastname", innerPlayer.getLastname());
				outputDreamTeamObject.put("team", innerPlayer.getTeam());
				JSONArray dreamTeamPosArray = new JSONArray();
				Iterator<String> dreamTeamPosIterator = innerPlayer.getPos().iterator();
				while (dreamTeamPosIterator.hasNext()) {
					dreamTeamPosArray.add(dreamTeamPosIterator.next());
				}
				outputDreamTeamObject.put("pos", dreamTeamPosArray);
				outputDreamTeamArray.add(outputDreamTeamObject);
			}
			outputObject.put("dreamTeam", outputDreamTeamArray);

			writer.write(outputObject.toJSONString());
			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("Pogresna putanja za ulazni fajl.");
		} catch (IOException e) {
			System.out.println("Greska pri unosu putanje.");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
