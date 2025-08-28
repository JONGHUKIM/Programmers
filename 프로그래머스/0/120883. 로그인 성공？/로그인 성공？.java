class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String status = "fail";
        
        for (int i = 0; i < db.length; i++) {
            String[] dbEntry = db[i];
            
            if (id_pw[0].equals(dbEntry[0])) {
                status = "wrong pw";
                if (id_pw[1].equals(dbEntry[1])) {
                    return "login";
                }
            } 
        }
        return status;
    }
}