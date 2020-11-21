package pl.matsuo.mdnotes.view;

import static j2html.TagCreator.text;
import static j2html.TagCreator.textarea;

import j2html.tags.ContainerTag;
import j2html.tags.Text;
import java.util.SortedMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.core.util.desktop.IView;
import pl.matsuo.mdnotes.component.ViewTemplate;
import pl.matsuo.mdnotes.model.Folder;
import pl.matsuo.mdnotes.model.MdNotesModel;

@Slf4j
@RequiredArgsConstructor
public class MdNotesMainView implements IView<IRequest, MdNotesModel> {

  final ViewTemplate template;

  @Override
  public ContainerTag view(IRequest request, MdNotesModel model) {
    return template.view(
        request, model, textarea(getContent(request.getParam("name"), model.getRoot())));
  }

  private Text getContent(String fileName, Folder folder) {
    if (fileName == null || fileName.isEmpty()) {
      return text("# Create your first file!\n\r> this is NOT a content of existing file");
    } else {
      if (fileName.contains("/")) {
        String[] split = fileName.split("[/]");
        return getContent(split[1], folder.getFolders().get(split[0]));
      } else {
        SortedMap<String, String> files = folder.getFiles();
        if (files.containsKey(fileName)) {
          return text(files.get(fileName));
        } else if (!files.isEmpty()) {
          return text(files.get(files.firstKey()));
        } else {
          return null;
        }
      }
    }
  }
}
