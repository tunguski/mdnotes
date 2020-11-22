package pl.matsuo.mdnotes;

import static pl.matsuo.core.util.desktop.component.ViewComponents.loadResource;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.DesktopUI;
import pl.matsuo.core.util.desktop.DesktopUIData;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.core.util.desktop.mvc.IActionController;
import pl.matsuo.core.util.desktop.mvc.IRequest;
import pl.matsuo.core.util.desktop.mvc.IView;
import pl.matsuo.mdnotes.action.AddFileAction;
import pl.matsuo.mdnotes.action.AddFolderAction;
import pl.matsuo.mdnotes.action.RenameFileAction;
import pl.matsuo.mdnotes.action.RenameFolderAction;
import pl.matsuo.mdnotes.action.ToggleFolderAction;
import pl.matsuo.mdnotes.component.ViewTemplate;
import pl.matsuo.mdnotes.model.MdNotesModel;
import pl.matsuo.mdnotes.view.MdNotesMainView;
import pl.matsuo.mdnotes.view.NoPageFoundView;

@Slf4j
public class MdNotes extends DesktopUI<MdNotesModel> {

  public static final String mdNotesCss = loadResource(MdNotes.class, "/css/mdnotes.css");

  public MdNotes() {
    super(desktopUiConfig());
  }

  private static DesktopUIData<MdNotesModel> desktopUiConfig() {
    MdNotesModel model = new MdNotesModel();
    return new DesktopUIData<>(views(), controllers(), model);
  }

  private static Map<String, IView<IRequest, MdNotesModel>> views() {
    Map<String, IView<IRequest, MdNotesModel>> views = new HashMap<>();

    ViewComponents viewComponents = new ViewComponents(mdNotesCss);
    FormComponents formComponents = new FormComponents();
    ViewTemplate viewTemplate = new ViewTemplate(viewComponents, formComponents);

    views.put("/", new MdNotesMainView(viewTemplate));
    views.put("/404", new NoPageFoundView(viewTemplate));

    return views;
  }

  private static Map<String, IActionController<IRequest, MdNotesModel>> controllers() {
    Map<String, IActionController<IRequest, MdNotesModel>> controllerMap = new HashMap<>();

    controllerMap.put("/files/add", new AddFileAction());
    controllerMap.put("/folders/add", new AddFolderAction());
    controllerMap.put("/files/rename", new RenameFileAction());
    controllerMap.put("/folders/rename", new RenameFolderAction());
    controllerMap.put("/folders/toggle", new ToggleFolderAction());

    return controllerMap;
  }
}
