package pl.matsuo.mdnotes.model;

import java.util.SortedMap;
import java.util.TreeMap;
import lombok.Data;

@Data
public class MdNotesModel {

  final SortedMap<String, String> files = new TreeMap<>();
}
