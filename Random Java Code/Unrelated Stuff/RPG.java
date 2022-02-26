import java.util.*;
public class RPG {

	public static void main(String[] args) 
	{
		
		Scanner reader = new Scanner(System.in);
		Random rng = new Random();
		int HP = 10;
		int maxHP=10;
		int magic = 5;
		int baseattack=1;
		int maxmagic=5;
		int defense=0;
		boolean passwordloaded=false;
		boolean defeated = false;
		int enemyattk = 0;
		int enemyHP = 0;
		int enemynum=1;
		int xp=0;
		boolean firstturn=true;
		enemyattk = rng.nextInt(3)+(enemynum);
		enemyHP = rng.nextInt(2)+(enemynum);
		while(defeated==false)
		{
			if(passwordloaded==false)
			{
				boolean validpassword=false;
				int passwordoption=0;
				
				System.out.println("Do you want to load a password 1-yes any other number-no");
				passwordoption=reader.nextInt();
				
				if(passwordoption==1 && validpassword==false)
				{
					String password = "";
					reader.nextLine();
					System.out.println("Passwords should be in format: MaxHP MaxMagic Attack EnemiesDefeated");
					System.out.println("If the program crashes or bugs out, you put in an invalid password");
					password=reader.nextLine();
					
					
					int hpindex=0;
					int magicindex=3;
					int attackindex=6;
					int enemyindex=9;
			
					if(password.length()==11)
					{
						maxHP = Integer.parseInt(password.substring(hpindex,hpindex+2));
						maxmagic = Integer.parseInt(password.substring(magicindex,magicindex+2));
						baseattack = Integer.parseInt(password.substring(attackindex,attackindex+2));
						enemynum = Integer.parseInt(password.substring(enemyindex,enemyindex+2))+1;
						validpassword=true;
					}
					else
					{
						System.out.println("Invalid Password");
					}
					
					if(validpassword==true)
					{
						System.out.println("Password Loaded");
						System.out.println("Max HP: " + maxHP);
						HP=maxHP;
						System.out.println("Max Magic: " + maxmagic);
						magic=maxmagic;
						System.out.println("Attack: " + baseattack);
						System.out.println("Enemies Defeated: " + (enemynum-1));
						passwordloaded=true;
					}
				}
				else
				{
					passwordloaded=true;
				}
			}
			boolean valid=false;
			int attack = baseattack;
			defense=0;
			while(valid==false)
			{
				if(firstturn==true)
				{
					System.out.println("What will you do 1-attack, 2-magic, 3-defend, 4-run");
					System.out.println("Your HP : " + HP + " Your Magic: " + magic + " XP: " + xp + "/100" + " Enemy HP: " + enemyHP + " Enemy Attack: " + enemyattk);
				}
				if(firstturn==false)
				{
					System.out.println("\n" + "What will you do 1-attack, 2-magic, 3-defend, 4-run");
					System.out.println("Your HP : " + HP + " Your Magic: " + magic + " XP: " + xp + "/100" + " Enemy HP: " + enemyHP + " Enemy Attack: " + enemyattk);
				}
				int menuoption = reader.nextInt();
				if(menuoption==1)
				{
					int crit=criticalHit();
					attack = baseattack;
					if(crit<=10)
					{
						attack +=2;
						System.out.println("Its a critical hit!");
					}
					
					
					System.out.println("You do " + attack + " damage to the enemy");
					enemyHP = (enemyHP-attack);
					if(enemyHP>0)
						System.out.println("The enemy has " + enemyHP + " health left");
					if(enemyHP<=0)
						System.out.println("The enemy has been defeated");
					valid=true;
				
				}

				if(menuoption==2)
				{
					if(magic>=1)
					{
						int magiccrit = criticalHit();
						attack = (baseattack * 2);
						if(magiccrit<=10)
						{
							attack +=2;
							System.out.println("Its a critical hit!");
						}
						System.out.println("You do " + attack + " damage to the enemy");
						enemyHP = (enemyHP-attack);
						if(enemyHP>0)
							System.out.println("The enemy has " + enemyHP + " health left");
						if(enemyHP<=0)
							System.out.println("The enemy has been defeated");
						magic--;
						System.out.println("You have " + magic + " magic points left");
						valid=true;
					}
					else
					{
						System.out.println("Not enough magic");
					}
					
				}
				if(menuoption==3)
				{
					defense=1;
					int guard = rng.nextInt(100)+1;
					if(guard<=10)
					{
						defense=enemyattk;
						System.out.println("You blocked all enemy damage for this turn");
					}
					if(guard<=25 && guard>10)
					{
						defense++;
						System.out.println("You guarded the enemy attack and your defense went up to 2");
					}
					if(guard>25)
					{
						System.out.println("Your defense went up to 1");
					}
					
					
					valid=true;
					}
				if(menuoption==4)
				{
					System.out.println("You ran away");
					HP=0;
					defeated=true;
					break;
				}
			}
			if(enemyHP>0 && valid==true)
			{
				if((enemyattk-defense)>0)
				{
					System.out.println("The enemy did " + (enemyattk-defense) + " damage to you");
					HP = (HP-enemyattk)+defense;
					if(HP>0)
					{
						System.out.println("You have " + HP + " health left");
					}
					if(HP<=0)
					{
						System.out.println("\n" + "GAME OVER");
					}
				}
				if((enemyattk-defense)<=0)
				{
					System.out.println("The enemy did " + "no damage to you");
				}
				if(HP<=0)
					defeated=true;
				
			}
			if(enemyHP<=0 && valid==true)
			{
				enemyHP = rng.nextInt(2)+(enemynum);
				enemyattk = rng.nextInt(3)+1;
				enemynum++;
				int currentxp=rng.nextInt(100)+1;
				xp+=currentxp;
				System.out.println("You got " + currentxp + " experience points");
				if(xp<100)
				{
					System.out.println("You now have: " + xp + " experience points");
					System.out.println("You need " + (100-xp) + " experience points to level up");
				}
				if(xp>=100)
				{
					xp = (xp-100);
					int levelupstat=0;
					while(levelupstat<1 || levelupstat>3)
					{
						System.out.println("You leveled up!");
						System.out.println("You now have: " + xp + " experience");
						System.out.println("Choose a stat to level up! 1- hp 2-magic 3 -attack");
						levelupstat=reader.nextInt();
						if(levelupstat==1)
						{ 
							HP = (maxHP+5);
							maxHP +=5;
							magic = maxmagic;
						}
						if(levelupstat==2)
						{
							magic = (maxmagic+5);
							maxmagic +=5;
							HP = maxHP;
						}
						if(levelupstat==3)
						{
							baseattack++;
							HP = maxHP;
							magic = maxmagic;
						}
					}
					
				}
			}
			if(firstturn=true)
			{
				firstturn=false;
			}
		}
		if((enemynum-1)==1)
		{
			System.out.println("You defeated " + "1" + " enemy");
			System.out.println("Your password is: " + maxHP + " " + maxmagic + " " + baseattack + " " + (enemynum-1));
			
		}
		else
		{
			System.out.println("You defeated " + (enemynum-1) + " enemies");
			System.out.println("Your password is: " + maxHP + " " + maxmagic + " " + baseattack + " " + (enemynum-1));
			
			
		}
		
			
			
		}
		public static int criticalHit()
		{
			Random rng = new Random();
			int critical = rng.nextInt(100)+1;
			return critical;
		}
	}


