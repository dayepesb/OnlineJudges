package ProblemsIn_Java.Notebook_Camus.Stringology;Pattern p = Pattern.compile("((P|U|I)=((-?\\d+\\.\\d+)|-?\\d+)(m|k|M)?(W|V|A))");
Matcher m = p.matcher(tec.readLine());
m.find();
String a = m.group();
m.find();
String b = m.group();
