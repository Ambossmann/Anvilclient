package anvilclient.anvilclient.gui.config;

import anvilclient.anvilclient.util.SettingManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.text.StringTextComponent;

public class FullbrightConfigGui extends ConfigScreen {

	public FullbrightConfigGui(Screen parentScreen) {
		super("anvilclient.configGui.fullbright.title", parentScreen);
	}
	
	public FullbrightConfigGui() {
		super("anvilclient.configGui.fullbright.title");
	}
	
	@Override
	protected void addOptions() {
		this.optionsRowList.addOption(new BooleanOption(
                "anvilclient.configGui.fullbright.title",
                unused -> SettingManager.getInstance().getFullbright(),
                (unused, newValue) -> SettingManager.getInstance().setFullbright(newValue)
        ));
		this.optionsRowList.addOption(new SliderPercentageOption(
		        "hbwhelper.configGui.hudX.title",
		        0.0, 12.0, (float) 0.1,
		        unused -> (double) SettingManager.getInstance().getFullbrightLevel(),
		        (unused, newValue) -> SettingManager.getInstance().setFullbrightLevel(newValue.doubleValue()),
		        // BiFunction that returns a string text component in format "<name>: <value>"
		        (gs, option) -> new StringTextComponent(
		                // Use I18n.format(String) to get a translation key's value
		                I18n.format("anvilclient.configGui.fullbrightLevel.title")
		                + ": "
		                + ((double) Math.round(((double) option.get(gs))*10))/10
		        )
		));
	}
	
}
