import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class RPGv2 extends JFrame implements ActionListener
{
	int HP = 20;
	int maxHP=20;
	int MP = 5;
	int baseattack=1;
	int maxmagic=5;
	int enemyattk = 1;
	int enemyHP = 1;
	int enemynum=1;
	int xp=0;
	int level=1;
	GridBagConstraints layoutConst=null;
	private JLabel hpLabel, enemyhpLabel, magicLabel, xpLabel, attkLabel, enemyattkLabel;
    private JTextField health, magic, enemyhp, attack, enemyattack, currentXP, log, log2, log3;
    private JButton attackCommand, magicCommand, runCommand, healCommand;
	public RPGv2()
	{
		setTitle("RPG");
		hpLabel = new JLabel("Your HP");
		attkLabel = new JLabel("Your Attack Power");
		xpLabel = new JLabel("XP");
		enemyhpLabel = new JLabel("Enemy HP");
		magicLabel = new JLabel("Magic");
		enemyattkLabel = new JLabel("Enemy Attack");
		
		health = new JTextField(10);
        health.setEditable(false);
        health.setText("" + HP);
        
        attack = new JTextField(10);
        attack.setEditable(false);
        attack.setText("" + baseattack);
          
        magic = new JTextField(10);
        magic.setEditable(false);
        magic.setText("" + MP);
        
        currentXP = new JTextField(10);
        currentXP.setEditable(false);
        currentXP.setText("" + xp);
        
        enemyhp = new JTextField(10);
        enemyhp.setEditable(false);
        enemyhp.setText("" + enemyHP);
        
        
        enemyattack = new JTextField(10);
        enemyattack.setEditable(false);
        enemyattack.setText("" + enemyattk);
        
        log = new JTextField(50);
        log.setEditable(false);
        log.setText("");
        
        log2 = new JTextField(50);
        log2.setEditable(false);
        log2.setText("");
        
        log3 = new JTextField(50);
        log3.setEditable(false);
        log3.setText("");
        
        attackCommand = new JButton("Attack");
        attackCommand.addActionListener(this);
        
        magicCommand = new JButton("Magic");
        magicCommand.addActionListener(this);
        
        runCommand = new JButton("Run");
        runCommand.addActionListener(this);
        
        healCommand = new JButton("Heal");
        healCommand.addActionListener(this);
        
        
        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();
  
        layoutConst.gridx=0;
        layoutConst.gridy=0;
        add(hpLabel, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=0;
        add(attkLabel, layoutConst);
       
        layoutConst.gridx=2;
        layoutConst.gridy=0;
        add(xpLabel, layoutConst);
        layoutConst.gridx=3;
        layoutConst.gridy=0;
        add(magicLabel, layoutConst);
        
        
        layoutConst.gridx=4;
        layoutConst.gridy=0;
        add(enemyhpLabel, layoutConst);
        
        layoutConst.gridx=5;
        layoutConst.gridy=0;
        add(enemyattkLabel, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=1;
        add(health, layoutConst);
        
        layoutConst.gridx=1;
        layoutConst.gridy=1;
        add(attack, layoutConst);
        
        layoutConst.gridx=2;
        layoutConst.gridy=1;
        add(currentXP, layoutConst);
        
        layoutConst.gridx=3;
        layoutConst.gridy=1;
        add(magic, layoutConst);
        
        layoutConst.gridx=4;
        layoutConst.gridy=1;
        add(enemyhp, layoutConst);
        
        layoutConst.gridx=5;
        layoutConst.gridy=1;
        add(enemyattack, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=5;
        add(log3, layoutConst);
        layoutConst.gridx=0;
        layoutConst.gridy=6;
        add(log, layoutConst);
        
        layoutConst.gridx=0;
        layoutConst.gridy=7;
        add(log2, layoutConst);
       
       
     
       
       layoutConst.gridx=0;
       layoutConst.gridy=4;
       add(attackCommand, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=4;
       add(magicCommand, layoutConst);
       
       layoutConst.gridx=2;
       layoutConst.gridy=4;
       add(runCommand, layoutConst);
       
       layoutConst.gridx=1;
       layoutConst.gridy=5;
       add(healCommand, layoutConst);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == attackCommand)
		{
			int crit=criticalHit();
			int attack = baseattack;
			if(crit<=10 && HP>0)
			{
				attack +=2;
				log.setText(("Its a critical hit!"));
			}
			else
			{
				log.setText("");
			}
			
			
			
			enemyHP = (enemyHP-attack);
			enemyhp.setText(""+enemyHP);
			if(enemyHP>0)
			{
				log3.setText("You do " + attack + " damage to the enemy, the enemy has " + enemyHP + " health left");
				enemyhp.setText(""+enemyHP);
				enemyAttack();
			}
				
			if(enemyHP<=0)
			{
				log3.setText("You do " + attack + " damage to the enemy, the enemy is defeated");
				enemynum++;
				levelUp();
				generateNewEnemy();
				enemyhp.setText(""+enemyHP);
				enemyattack.setText("" + enemyattk);
			}
				
		}
		if(e.getSource() == magicCommand)
		{
			if(MP>=1)
			{
				int magiccrit = criticalHit();
				int attack = (baseattack * 2);
				if(magiccrit<=10  && HP>0)
				{
					attack +=2;
					log.setText("Its a critical hit!");
				}
				enemyHP = (enemyHP-attack);
				if(enemyHP>0)
				{
					log3.setText("You do " + attack + " damage to the enemy, the enemy has " + enemyHP + " health left");
					enemyhp.setText(""+enemyHP);
					enemyAttack();
				}
					
				if(enemyHP<=0)
				{
					log3.setText("You do " + attack + " damage to the enemy, the enemy is defeated");
					enemynum++;
					generateNewEnemy();
					levelUp();
					enemyhp.setText(""+enemyHP);
					enemyattack.setText("" + enemyattk);
				}
				MP--;
				log.setText("You have " + MP + " magic points left");
				magic.setText(""+MP);
				
				
				
			}
			else
			{
				log.setText("Not enough magic");
			}
		}
		if(e.getSource() == healCommand)
		{
			healSpell();
		}
		if(e.getSource() == runCommand) 
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		 RPGv2 myFrame = new RPGv2();
		 myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     myFrame.pack();
	     myFrame.setVisible(true);
	}
	public void enemyAttack()
	{
		log.setText("The enemy did " + enemyattk + " damage to you");
		HP = (HP-enemyattk);
		if(HP>0)
		{
			log2.setText("You have " + HP + " health left");
			health.setText(""+HP);
		}
		if(HP<=0)
		{
			health.setText("0");
			log3.setText("GAME OVER");
			log.setText("You defeated " + (enemynum-1) + " enemies");
			log2.setText("Please press the run button or close the program");
			
			baseattack=0;
			MP=0;
			enemyattk=0;
			
		}
	  
	}
	public void levelUp()
	{
		Random rng = new Random();
		int currentxp=rng.nextInt(20)+10;
		xp+=currentxp;
		if(xp<100)
		{
			log.setText("You now have " + xp + " experience points");
			currentXP.setText(""+xp +"/100");
			log2.setText("You need " + (100-xp) + " experience points to level up");
			
		}
		if(xp>=100)
		{
			xp = (xp-100);
			currentXP.setText(""+xp +"/100");
			log3.setText("You leveled up!");
			log.setText("You now have " + xp + " experience");
			int hpincrease = rng.nextInt(10)+1;
			int magicincrease = rng.nextInt(5)+1;
			int attackincrease = rng.nextInt(3)+1;
			log2.setText("Your stats have increased HP by " + hpincrease + ", Magic by " + magicincrease + ", and Attack by " + attackincrease);
			maxHP+=hpincrease;
			maxmagic+=magicincrease;
			baseattack+=attackincrease;
			HP = maxHP;
			MP = maxmagic;
			
			health.setText("" + HP);
			magic.setText("" + MP);
			attack.setText("" + baseattack);
			
			
			
		}
	}
	public void healSpell()
	{
		if(MP>=3)
		{
			Random rng = new Random();
			int healamount = (maxHP/3)+rng.nextInt(5);
			HP+=healamount;
			if(HP>maxHP)
				HP=maxHP;
			log3.setText("You healed " + healamount + " HP");
			MP-=3;
			health.setText(""+HP);
			magic.setText(""+MP);
			enemyAttack();
		}
		else 
		{
			log.setText("Not enough magic");
		}
	}
	public void generateNewEnemy()
	{
		Random rng = new Random(); 
		enemyHP = (rng.nextInt(2)+1)+(enemynum/2);
		enemyattk = (rng.nextInt(3)+1)+(enemynum/10);
	}
	public static int criticalHit()
	{
		Random rng = new Random();
		int critical = rng.nextInt(100)+1;
		return critical;
	}
}
