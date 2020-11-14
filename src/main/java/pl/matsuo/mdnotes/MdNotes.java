package pl.matsuo.mdnotes;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.DesktopUI;
import pl.matsuo.core.util.desktop.DesktopUIData;
import pl.matsuo.core.util.desktop.IActionController;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.core.util.desktop.IView;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.mdnotes.model.MdNotesModel;
import pl.matsuo.mdnotes.view.MdNotesMainView;

@Slf4j
public class MdNotes extends DesktopUI<MdNotesModel> {

  public MdNotes() {
    super(desktopUiConfig());
  }

  private static DesktopUIData<MdNotesModel> desktopUiConfig() {
    MdNotesModel model = new MdNotesModel();
    return new DesktopUIData<>(views(), controllers(), model);
  }

  private static Map<String, IView<IRequest, MdNotesModel>> views() {
    Map<String, IView<IRequest, MdNotesModel>> views = new HashMap<>();

    ViewComponents viewComponents = new ViewComponents();
    FormComponents formComponents = new FormComponents();

    views.put("/", new MdNotesMainView(viewComponents, formComponents));

    return views;
  }

  private static Map<String, IActionController<IRequest, MdNotesModel>> controllers() {
    Map<String, IActionController<IRequest, MdNotesModel>> controllerMap = new HashMap<>();

    return controllerMap;
  }
}
