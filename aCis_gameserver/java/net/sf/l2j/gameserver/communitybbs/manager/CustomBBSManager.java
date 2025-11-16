package net.sf.l2j.gameserver.communitybbs.manager;

import java.util.StringTokenizer;

import net.sf.l2j.gameserver.model.actor.Player;

public class CustomBBSManager extends BaseBBSManager
{
	protected CustomBBSManager()
	{
	}

	@Override
	public void parseCmd(String command, Player player)
	{
		if (command.equals("_bbscustom"))
			loadStaticHtm("index.htm", player);
		else if (command.startsWith("_bbscustom;"))
		{
			final StringTokenizer st = new StringTokenizer(command, ";");
			st.nextToken();

			loadStaticHtm(st.nextToken() + ".htm", player);
		}
		else
			super.parseCmd(command, player);
	}

	@Override
	protected String getFolder()
	{
		return "custom/";
	}

	public static CustomBBSManager getInstance()
	{
		return SingletonHolder.INSTANCE;
	}

	private static class SingletonHolder
	{
		protected static final CustomBBSManager INSTANCE = new CustomBBSManager();
	}
}
